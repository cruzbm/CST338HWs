import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Test cases for OnlineStore class
 *      - hw5, CST 338
 *
 * Note:
 *      This code won't work if a static scanner is in your OnlineStore.
 *
 * @author  Donald Dong
 * @since   2017/9/25
 */

public class OnlineStoreTest {

    interface Block {
        void call() throws Exception;
    }

    private static void setInput(String input) throws Exception {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8.name()));
        System.setIn(stream);
    }

    // Reference: https://stackoverflow.com/questions/3228427/redirect-system-out-println
    private static String copyOutput(Block block) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(bos, true);
        PrintStream oldStream = System.out;
        System.setOut(printStream);
        try {
            block.call();
        }
        finally {
            System.setOut(oldStream);
        }
        return bos.toString();
    }

    private static void match(Block block, String expected, String from) throws Exception{
        String output = copyOutput(block);
        if (!output.replaceAll("\\s","").equals(expected.replaceAll("\\s",""))) {
            throw new Exception("Warning, output doesn't match," + from + "\n" +
                    "\n OUTPUT > \n" + output +
                    "\n\n EXPECTED > \n" + expected);
        }
    }

    private static void addProduct() throws Exception {
        setInput(
            "1111\n" +
            "product1\n" +
            "200.0\n" +
            "1111\n" +
            "product2\n" +
            "300.0"
        );

        String expected =
                "Product Number: Product Name: Product Price: Product Added – product1, No: 1111, Price: 200.00\n" +
                "Product Number: Product Name: Product Price: Input Error: Product 1111 already exists.\n";

        match(() -> {
            OnlineStore onlineStore = new OnlineStore("test");
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, product1");
            }
            if (onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, duplicated product number, product2");
            }
        }, expected, "OnlineStore::addProduct");
    }

    private static void deleteProduct() throws Exception {
        setInput(
            "1111\n" +
            "1111\n" +
            "product1\n" +
            "200.0\n" +
            "1111\n"
        );

        OnlineStore onlineStore = new OnlineStore("test");
        match(() -> {
            if (onlineStore.deleteProduct()) {
                throw new Exception("Test failed, OnlineStore::deleteProduct, delete empty product");
            }
        }, "Product Number To Delete: Input Error: Product 1111 doesn’t exist.\n",
                "OnlineStore::deleteProduct");

        match(() -> {
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, basic operation");
            }
        }, "Product Number: Product Name: Product Price: Product Added – product1, No: 1111, Price: 200.00\n",
                "OnlineStore::addProduct");

        match(() -> {
            if (!onlineStore.deleteProduct()) {
                throw new Exception("Test failed, OnlineStore::deleteProduct");
            }
        }, "Product Number To Delete: Product 1111 deleted.\n",
                "OnlineStore::deleteProduct");
    }

    private static void productInfo() throws Exception {
        setInput(
            "1111\n" +
            "product1\n" +
            "200.0\n" +
            "2222\n" +
            "product2\n" +
            "300.00\n" +
            "\n" +
            "1111\n" +
            "1111\n" +
            "2222\n" +
            "\n"
        );

        OnlineStore onlineStore = new OnlineStore("test");
        match(() -> {
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, product1");
            }
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, product2");
            }
        }, "Product Number: Product Name: Product Price: Product Added – product1, No: 1111, Price: 200.00\n" +
                "Product Number: Product Name: Product Price: Product Added – product2, No: 2222, Price: 300.00\n",
                "OnlineStore::addProduct");

        match(() -> onlineStore.productInfo(),
                "Enter product number (Just enter for all products): 1. product1 (No. 1111): $200.00\n" +
                "2. product2 (No. 2222): $300.00\n",
                "OnlineStore::productInfo");

        match(() -> {
            if (!onlineStore.deleteProduct()) {
                throw new Exception("Test failed, OnlineStore::deleteProduct, product1");
            }
        }, "Product Number To Delete: Product 1111 deleted.\n", "OnlineStore::deleteProduct");


        match(() -> onlineStore.productInfo(),
                "Enter product number (Just enter for all products): Input Error: Product 1111 doesn’t exist.\n",
                "OnlineStore::productInfo");


        match(() -> {
            if (!onlineStore.deleteProduct()) {
                throw new Exception("Test failed, OnlineStore::deleteProduct, product2");
            }
        }, "Product Number To Delete: Product 2222 deleted.\n", "OnlineStore::deleteProduct");

        match(() -> onlineStore.productInfo(),
                "Enter product number (Just enter for all products): ",
                "OnlineStore::productInfo");
    }

    private static void makeOrder() throws Exception {
        setInput(
            "1000\n" +
            "1111\n" +
            "0\n" +
            "1111\n" +
            "product1\n" +
            "1.10\n" +
            "2222\n" +
            "product2\n" +
            "10.01\n" +
            "1000\n" +
            "1002\n" +
            "1111\n" +
            "2222\n" +
            "0\n"
        );

        OnlineStore onlineStore = new OnlineStore("test");

        match(() -> {
            if(!onlineStore.makeOrder()) {
                throw new Exception("Test failed, OnlineStore::makeOrder");
            }
        },
                "Order Number: Type Product Number (0 to finish): Error: Product 1111 does not exist.\n" +
                        "Type Product Number (0 to finish): Order Info – Order Number: 1000\n" +
                        "             Total Price: $0.00\n",
                "OnlineStore::makeOrder");

        match(() -> {
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, product1");
            }
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, product2");
            }
        }, "Product Number: Product Name: Product Price: Product Added – product1, No: 1111, Price: 1.10\n" +
                        "Product Number: Product Name: Product Price: Product Added – product2, No: 2222, Price: 10.01\n",
        "OnlineStore::addProduct");

        match(() -> {
            if(onlineStore.makeOrder()) {
                throw new Exception("Test failed, OnlineStore::makeOrder, duplicated order id");
            }
            if(!onlineStore.makeOrder()) {
                throw new Exception("Test failed, OnlineStore::makeOrder");
            }
        }, "Order Number: Error: Order 1000 already exists.\n" +
                "Order Number: Type Product Number (0 to finish): Type Product Number (0 to finish): Type Product Number (0 to finish): Order Info – Order Number: 1002\n" +
                "             Item 1: product1 (No. 1111): $1.10\n" +
                "             Item 2: product2 (No. 2222): $10.01\n" +
                "             Total Price: $11.11\n",
                "OnlineStore::makeOrder");
    }

    private static void updateProduct() throws Exception {
        setInput(
                "1000\n" +
                "1111\n" +
                "product1\n" +
                "1.10\n" +
                "1111\n" +
                "\n" +
                "\n" +
                "1111\n" +
                "iPhoneX\n" +
                "999.9\n"
        );

        OnlineStore onlineStore = new OnlineStore("test");

        match(() -> {
            if (onlineStore.updateProduct()) {
                throw new Exception("Test failed, OnlineStore::updateProduct");
            }
        }, "Product Number To Update: Input Error: Product 1000 doesn’t exist.\n",
                "OnlineStore::updateProduct");

        match(() -> {
            if(!onlineStore.addProduct()) {
                throw new Exception("Test failed, OnlineStore::addProduct, product1");
            }
        }, "Product Number: Product Name: Product Price: Product Added – product1, No: 1111, Price: 1.10\n",
        "OnlineStore::addProduct");

        match(() -> {
            if (!onlineStore.updateProduct()) {
                throw new Exception("Test failed, OnlineStore::updateProduct");
            }
            if (!onlineStore.updateProduct()) {
                throw new Exception("Test failed, OnlineStore::updateProduct");
            }
        }, "Product Number To Update: If you do not want to change data, press the Enter key.\n" +
                        "Product Name (product1): Product Price (1.1):Product Updated – product1, No: 1111, Price: 1.10\n" +
                        "Product Number To Update: If you do not want to change data, press the Enter key.\n" +
                        "Product Name (product1): Product Price (1.1):Product Updated – iPhoneX, No: 1111, Price: 999.90\n",
        "OnlineStore::updateProduct");
    }

    public static void main(String[] args) {
    		
        try {
            addProduct();
//            deleteProduct();
//            productInfo();
//            makeOrder();
//            updateProduct();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }
}