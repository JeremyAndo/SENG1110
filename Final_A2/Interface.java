//c3315176 - Jeremy Anderson
import java.io.*;
import java.util.*;

public class Interface {

    private static Scanner console = new Scanner(System.in);
    //declare variables and arrays
    private int option;
    private Depot depot[] = new Depot[4];

    private void run(){

        //method that runs majority of the program
        do {
            System.out.println("[0. Exit]");
            System.out.println("[1. Add Depot]");
            System.out.println("[2. Remove Depot]");
            System.out.println("[3. Add Product Item]");
            System.out.println("[4. Remove Product Items]");
            System.out.println("[5. List Depots]");
            System.out.println("[6. List Products]");
            System.out.println("[7. Show Product Info]");
            System.out.println("[8. Get Cumulative Value of Depot]");
            System.out.println("[9. Export Information to a File]");
            System.out.println("[10. Import Information from a File]");
            System.out.println("Choose an option listed above: ");
            option = console.nextInt();

            switch(option) {
                default:
                    System.out.println("ERROR: Invalid Input!");
                case 0:
                    break;
                case 1: //check if there is room for a depot, if there is, run addDepot();
                    if (depot[0] != null)
                        if (depot[1] != null)
                            if (depot[2] != null)
                                if (depot[3] != null) {
                                    System.out.println("ERROR: 4 Depots already exist!");
                                    break;
                                }
                    addDepot();
                    break;
                case 2: //check if depots exist, if they do, run removeDepot();
                    if (depot[0] == null)
                        if (depot[1] == null)
                            if (depot[2] == null)
                                if (depot[3] == null) {
                                    System.out.println("ERROR: No Depots currently exist!");
                                    break;
                                }
                    removeDepot();
                    break;
                case 3: //first check if any depots exists
                    /**
                     * ADD A FEATURE so that if i=j when overriding a product, then it adds to the existing product in that depot, instead of creating a duplicate
                     */
                    if (depot[0] == null)
                        if (depot[1] == null)
                            if (depot[2] == null)
                                if (depot[3] == null) {
                                    System.out.println("ERROR: No Depots currently exist!");
                                    break;
                                }
                    //check if there are any free slots for a product
                    int x, y;
                    int maxProduct = 0;
                    for (x = 0; x <= 3; x++) {
                        if (depot[x] != null) {
                            if (depot[x].getProduct0() != null)
                                maxProduct++;
                            if (depot[x].getProduct1() != null)
                                maxProduct++;
                            if (depot[x].getProduct2() != null)
                                maxProduct++;
                            if (depot[x].getProduct3() != null)
                                maxProduct++;
                            if (depot[x].getProduct4() != null)
                                maxProduct++;
                        } else {
                            maxProduct += 5;
                        }
                    }
                    if (maxProduct == 20) {
                        System.out.println("ERROR: All existing Depots are full of Products, create a new Depot or remove Products.");
                        break;
                    }
                    //the program will continue if there are depots that exist, and there is at least one spot left for a product
                    //a new product will be created via new information or an existing product in another depot
                    //does not need to check for space in depots or they exist as checked previously in case
                    System.out.println("Enter name of depot to add product to: ");
                    String tempDepotInput = console.next();
                    int doesNotExist2 = 0;
                    int addNewProduct = 0;
                    int noRoomInDepot = 0;
                    int product0Free = 0, product1Free = 0, product2Free = 0, product3Free = 0, product4Free = 0;
                    int i, j;
                    //depot[i] is where we want to add a new product, depot[j] is where we are checking
                    for (i = 0; i <= 3; i++) {
                        try {
                            if (tempDepotInput.equalsIgnoreCase(depot[i].getDepotName())) {
                                /**
                                 * try to add so name entry for product is only available if products exist, the check currently occurs after asking for a product name
                                 */
                                System.out.println("Enter name of new product: ");
                                String tempProductInput;
                                tempProductInput = console.next();
                                //now that the depot is selected, we just need to search if the product already exists, otherwise we can simply add it normally
                                if (depot[i].getProduct0() == null) {
                                    product0Free++;
                                } else if (depot[i].getProduct1() == null) {
                                    product1Free++;
                                } else if (depot[i].getProduct2() == null) {
                                    product2Free++;
                                } else if (depot[i].getProduct3() == null) {
                                    product3Free++;
                                } else if (depot[i].getProduct4() == null) {
                                    product4Free++;
                                } else {
                                    noRoomInDepot++;
                                }

                                //now that there is room in the depot, it continues, otherwise it tells the program to give an error
                                if (noRoomInDepot == 0) {
                                    //now checks each depot for if a product exists with the same, if it does it adds the data to an available slot, otherwise, just adds normally
                                    //nest the rest of this later
                                    for (j = 0; j <= 3; j++) {
                                        if (depot[j] != null) {

                                            /**
                                             * repeating sequence, product0
                                             */
                                            if (depot[j].getProduct0() != null) {
                                                if (tempProductInput.equalsIgnoreCase(depot[j].getProduct0().getProductName())) {
                                                    System.out.println(tempProductInput + " already exists in another Depot.");
                                                    System.out.println("Using existing information to make new Product.");
                                                    //take existing info and add to a spare spot
                                                    String productName = depot[j].getProduct0().getProductName();
                                                    double productPrice = depot[j].getProduct0().getProductPrice();
                                                    double productWeight = depot[j].getProduct0().getProductWeight();
                                                    System.out.println("Enter a quantity for this product: ");
                                                    int productQuantity = console.nextInt();
                                                    while (productQuantity <= 0) {
                                                        System.out.println("ERROR: The quantity must be positive! Enter a new quantity: ");
                                                        productQuantity = console.nextInt();
                                                    }
                                                    //check which space to add product to
                                                    if (product0Free > 0) {
                                                        depot[i].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct0().getProductName() + " was created.");
                                                        break;
                                                    } else if (product1Free > 0) {
                                                        depot[i].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct1().getProductName() + " was created.");
                                                        break;
                                                    } else if (product2Free > 0) {
                                                        depot[i].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct2().getProductName() + " was created.");
                                                        break;
                                                    } else if (product3Free > 0) {
                                                        depot[i].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct3().getProductName() + " was created.");
                                                        break;
                                                    } else if (product4Free > 0) {
                                                        depot[i].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct4().getProductName() + " was created.");
                                                        break;
                                                    }
                                                } else {
                                                    addNewProduct++;
                                                }
                                            } else {
                                                addNewProduct++;
                                            }

                                            /**
                                             * repeating sequence, product1
                                             */

                                            if (depot[j].getProduct1() != null) {
                                                if (tempProductInput.equalsIgnoreCase(depot[j].getProduct1().getProductName())) {
                                                    System.out.println(tempProductInput + " already exists in another Depot.");
                                                    System.out.println("Using existing information to make new Product.");
                                                    //take existing info and add to a spare spot
                                                    String productName = depot[j].getProduct1().getProductName();
                                                    double productPrice = depot[j].getProduct1().getProductPrice();
                                                    double productWeight = depot[j].getProduct1().getProductWeight();
                                                    System.out.println("Enter a quantity for this product: ");
                                                    int productQuantity = console.nextInt();
                                                    while (productQuantity <= 0) {
                                                        System.out.println("ERROR: The quantity must be positive! Enter a new quantity: ");
                                                        productQuantity = console.nextInt();
                                                    }
                                                    //check which space to add product to
                                                    if (product0Free > 0) {
                                                        depot[i].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct0().getProductName() + " was created.");
                                                        break;
                                                    } else if (product1Free > 0) {
                                                        depot[i].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct1().getProductName() + " was created.");
                                                        break;
                                                    } else if (product2Free > 0) {
                                                        depot[i].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct2().getProductName() + " was created.");
                                                        break;
                                                    } else if (product3Free > 0) {
                                                        depot[i].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct3().getProductName() + " was created.");
                                                        break;
                                                    } else if (product4Free > 0) {
                                                        depot[i].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct4().getProductName() + " was created.");
                                                        break;
                                                    }
                                                } else {
                                                    addNewProduct++;
                                                }
                                            } else {
                                                addNewProduct++;
                                            }

                                            /**
                                             * repeating sequence, product2
                                             */

                                            if (depot[j].getProduct2() != null) {
                                                if (tempProductInput.equalsIgnoreCase(depot[j].getProduct2().getProductName())) {
                                                    System.out.println(tempProductInput + " already exists in another Depot.");
                                                    System.out.println("Using existing information to make new Product.");
                                                    //take existing info and add to a spare spot
                                                    String productName = depot[j].getProduct2().getProductName();
                                                    double productPrice = depot[j].getProduct2().getProductPrice();
                                                    double productWeight = depot[j].getProduct2().getProductWeight();
                                                    System.out.println("Enter a quantity for this product: ");
                                                    int productQuantity = console.nextInt();
                                                    while (productQuantity <= 0) {
                                                        System.out.println("ERROR: The quantity must be positive! Enter a new quantity: ");
                                                        productQuantity = console.nextInt();
                                                    }
                                                    //check which space to add product to
                                                    if (product0Free > 0) {
                                                        depot[i].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct0().getProductName() + " was created.");
                                                        break;
                                                    } else if (product1Free > 0) {
                                                        depot[i].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct1().getProductName() + " was created.");
                                                        break;
                                                    } else if (product2Free > 0) {
                                                        depot[i].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct2().getProductName() + " was created.");
                                                        break;
                                                    } else if (product3Free > 0) {
                                                        depot[i].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct3().getProductName() + " was created.");
                                                        break;
                                                    } else if (product4Free > 0) {
                                                        depot[i].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct4().getProductName() + " was created.");
                                                        break;
                                                    }
                                                } else {
                                                    addNewProduct++;
                                                }
                                            } else {
                                                addNewProduct++;
                                            }

                                            /**
                                             * repeating sequence, product3
                                             */

                                            if (depot[j].getProduct3() != null) {
                                                if (tempProductInput.equalsIgnoreCase(depot[j].getProduct3().getProductName())) {
                                                    System.out.println(tempProductInput + " already exists in another Depot.");
                                                    System.out.println("Using existing information to make new Product.");
                                                    //take existing info and add to a spare spot
                                                    String productName = depot[j].getProduct3().getProductName();
                                                    double productPrice = depot[j].getProduct3().getProductPrice();
                                                    double productWeight = depot[j].getProduct3().getProductWeight();
                                                    System.out.println("Enter a quantity for this product: ");
                                                    int productQuantity = console.nextInt();
                                                    while (productQuantity <= 0) {
                                                        System.out.println("ERROR: The quantity must be positive! Enter a new quantity: ");
                                                        productQuantity = console.nextInt();
                                                    }
                                                    //check which space to add product to
                                                    if (product0Free > 0) {
                                                        depot[i].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct0().getProductName() + " was created.");
                                                        break;
                                                    } else if (product1Free > 0) {
                                                        depot[i].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct1().getProductName() + " was created.");
                                                        break;
                                                    } else if (product2Free > 0) {
                                                        depot[i].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct2().getProductName() + " was created.");
                                                        break;
                                                    } else if (product3Free > 0) {
                                                        depot[i].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct3().getProductName() + " was created.");
                                                        break;
                                                    } else if (product4Free > 0) {
                                                        depot[i].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct4().getProductName() + " was created.");
                                                        break;
                                                    }
                                                } else {
                                                    addNewProduct++;
                                                }
                                            } else {
                                                addNewProduct++;
                                            }

                                            /**
                                             * repeating sequence, product4
                                             */

                                            if (depot[j].getProduct4() != null) {
                                                if (tempProductInput.equalsIgnoreCase(depot[j].getProduct4().getProductName())) {
                                                    System.out.println(tempProductInput + " already exists in another Depot.");
                                                    System.out.println("Using existing information to make new Product.");
                                                    //take existing info and add to a spare spot
                                                    String productName = depot[j].getProduct4().getProductName();
                                                    double productPrice = depot[j].getProduct4().getProductPrice();
                                                    double productWeight = depot[j].getProduct4().getProductWeight();
                                                    System.out.println("Enter a quantity for this product: ");
                                                    int productQuantity = console.nextInt();
                                                    while (productQuantity <= 0) {
                                                        System.out.println("ERROR: The quantity must be positive! Enter a new quantity: ");
                                                        productQuantity = console.nextInt();
                                                    }
                                                    //check which space to add product to
                                                    if (product0Free > 0) {
                                                        depot[i].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct0().getProductName() + " was created.");
                                                        break;
                                                    } else if (product1Free > 0) {
                                                        depot[i].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct1().getProductName() + " was created.");
                                                        break;
                                                    } else if (product2Free > 0) {
                                                        depot[i].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct2().getProductName() + " was created.");
                                                        break;
                                                    } else if (product3Free > 0) {
                                                        depot[i].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct3().getProductName() + " was created.");
                                                        break;
                                                    } else if (product4Free > 0) {
                                                        depot[i].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                                                        System.out.println("Product " + depot[i].getProduct4().getProductName() + " was created.");
                                                        break;
                                                    }
                                                } else {
                                                    addNewProduct++;
                                                }
                                            } else {
                                                addNewProduct++;
                                            }
                                        } else {
                                            addNewProduct += 5;
                                        }
                                    }

                                    if (addNewProduct == 20) {
                                        //add new product normally
                                        //remember to add checks to make sure weight, quantity and price are positive
                                        double productPrice, productWeight;
                                        int productQuantity;
                                        System.out.println("Product Price ($): ");
                                        productPrice = console.nextDouble();
                                        while (productPrice <= 0) {
                                            System.out.println("ERROR: Price must be positive!");
                                            productPrice = console.nextDouble();
                                        }
                                        System.out.println("Product Weight (KG): ");
                                        productWeight = console.nextDouble();
                                        while (productWeight <= 0) {
                                            System.out.println("ERROR: Weight must be positive!");
                                            productWeight = console.nextDouble();
                                        }
                                        System.out.println("Product Quantity: ");
                                        productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: Quantity must be positive!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (product0Free > 0) {
                                            depot[i].setProduct0(new Product(tempProductInput, productPrice, productWeight, productQuantity));
                                            System.out.println(depot[i].getProduct0().getProductName() + " was created.");
                                        } else if (product1Free > 0) {
                                            depot[i].setProduct1(new Product(tempProductInput, productPrice, productWeight, productQuantity));
                                            System.out.println(depot[i].getProduct1().getProductName() + " was created.");
                                        } else if (product2Free > 0) {
                                            depot[i].setProduct2(new Product(tempProductInput, productPrice, productWeight, productQuantity));
                                            System.out.println(depot[i].getProduct2().getProductName() + " was created.");
                                        } else if (product3Free > 0) {
                                            depot[i].setProduct3(new Product(tempProductInput, productPrice, productWeight, productQuantity));
                                            System.out.println(depot[i].getProduct3().getProductName() + " was created.");
                                        } else if (product4Free > 0) {
                                            depot[i].setProduct4(new Product(tempProductInput, productPrice, productWeight, productQuantity));
                                            System.out.println(depot[i].getProduct4().getProductName() + " was created.");
                                        }
                                    }
                                } else {
                                    System.out.println("ERROR: There is no room in this depot for another Product!");
                                }
                            } else
                                doesNotExist2++;
                        } catch (Exception e) {
                            doesNotExist2++;
                        }
                    }
                    if (doesNotExist2 == 4) {
                        System.out.println("ERROR: This depot does not exist!");
                    }
                    break;
                case 4: //check that any depots exist
                    if (depot[0] == null)
                        if (depot[1] == null)
                            if (depot[2] == null)
                                if (depot[3] == null) {
                                    System.out.println("ERROR: No Depots currently exist!");
                                    break;
                                }
                    //check if there any available products to be removed
                    int m,noProductsExist = 0;
                    //
                    for (m = 0; m<=3; m++){
                        if (depot[m] != null){
                            try {
                                depot[m].getProduct0().getProductName();
                            } catch (Exception e){
                                noProductsExist++;
                            }
                            try {
                                depot[m].getProduct1().getProductName();
                            } catch (Exception e){
                                noProductsExist++;
                            }
                            try {
                                depot[m].getProduct2().getProductName();
                            } catch (Exception e){
                                noProductsExist++;
                            }
                            try {
                                depot[m].getProduct3().getProductName();
                            } catch (Exception e){
                                noProductsExist++;
                            }
                            try {
                                depot[m].getProduct4().getProductName();
                            } catch (Exception e){
                                noProductsExist++;
                            }
                        } else {
                            noProductsExist += 5;
                        }
                    }
                    //prints error if all above statements of try - catch add to counter/no products exist
                    if (noProductsExist == 20){
                        System.out.println("ERROR: No Products currently exist!");
                        break;
                    }
                    removeProduct();
                    break;
                case 5: listDepots();
                    break;
                case 6: //check that any depots exist
                    if (depot[0] == null)
                        if (depot[1] == null)
                            if (depot[2] == null)
                                if (depot[3] == null) {
                                    System.out.println("ERROR: No Depots currently exist!");
                                    break;
                                }
                    listProducts();
                    break;
                case 7: searchForProduct();
                    break;
                case 8: //check that any depots exist
                    if (depot[0] == null)
                        if (depot[1] == null)
                            if (depot[2] == null)
                                if (depot[3] == null) {
                                    System.out.println("ERROR: No Depots currently exist!");
                                    break;
                                }
                    cumulativeValue();
                    break;
                case 9:
                    try {
                        exportFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 10:
                    try {
                        importFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }



        } while (option!=0);
    }


    public static void main(String[] args){
        Interface intFace = new Interface();
        intFace.run();
    }

    private void addDepot() {
        int alreadyExists = 0;
        System.out.println("Name of new depot: ");
        String tempInput = console.next();
        //checks if depot already exists
        if (depot[0] != null)
            if (tempInput.equalsIgnoreCase(depot[0].getDepotName()))
                alreadyExists++;
        if (depot[1] != null)
            if (tempInput.equalsIgnoreCase(depot[1].getDepotName()))
                alreadyExists++;
        if (depot[2] != null)
            if (tempInput.equalsIgnoreCase(depot[2].getDepotName()))
                alreadyExists++;
        if (depot[3] != null)
            if (tempInput.equalsIgnoreCase(depot[3].getDepotName()))
                alreadyExists++;
        //if depot already exists, it gives an error, otherwise it creates depot in spare space
        if (alreadyExists > 0)
            System.out.println("ERROR: This depot already exists!");
        else {
            if (depot[0] == null) {
                depot[0] = new Depot(tempInput.toLowerCase());
                System.out.println(depot[0].getDepotName() + " was created as a new depot.");
            } else if (depot[1] == null) {
                depot[1] = new Depot(tempInput.toLowerCase());
                System.out.println(depot[1].getDepotName() + " was created as a new depot.");
            } else if (depot[2] == null) {
                depot[2] = new Depot(tempInput.toLowerCase());
                System.out.println(depot[2].getDepotName() + " was created as a new depot.");
            } else if (depot[3] == null) {
                depot[3] = new Depot(tempInput.toLowerCase());
                System.out.println(depot[3].getDepotName() + " was created as a new depot.");
            }
        }
    }

    private void removeDepot(){
        int doesNotExist = 0;
        System.out.println("Name of depot to remove: ");
        String tempInput = console.next();
        //checks what depots exist and if the input matches all individually
        if (depot[0] != null)
            if (tempInput.equalsIgnoreCase(depot[0].getDepotName())) {
                System.out.println(depot[0].getDepotName() + " was removed.");
                depot[0] = null;
            } else {
                doesNotExist++;
            }
        else
            doesNotExist++;
        if (depot[1] != null)
            if (tempInput.equalsIgnoreCase(depot[1].getDepotName())) {
                System.out.println(depot[1].getDepotName()+" was removed.");
                depot[1] = null;
            } else {
                doesNotExist++;
            }
        else
            doesNotExist++;
        if (depot[2] != null)
            if (tempInput.equalsIgnoreCase(depot[2].getDepotName())) {
                System.out.println(depot[2].getDepotName()+" was removed.");
                depot[2] = null;
            } else {
                doesNotExist++;
            }
        else
            doesNotExist++;
        if (depot[3] != null)
            if (tempInput.equalsIgnoreCase(depot[3].getDepotName())) {
                System.out.println(depot[3].getDepotName()+" was removed.");
                depot[3] = null;
            } else {
                doesNotExist++;
            }
        else
            doesNotExist++;

        if (doesNotExist == 4)
            System.out.println("ERROR: This depot does not exist!");
    }

    private void removeProduct(){
        //
        System.out.println("Select a Depot to remove Product from: ");
        String tempDepotInput = console.next();
        int doesNotExist = 0;
        int invalidProduct = 0;
        int i;
        for (i=0;i<=3;i++){
            try {
                if (tempDepotInput.equalsIgnoreCase(depot[i].getDepotName())){
                    System.out.println(depot[i].getDepotName()+" was chosen.");
                    System.out.println("Now choose a Product to remove items from: ");
                    String tempProductInput = console.next();
                    //try for product0 of depot[i] that was selected
                    try {
                        if (tempProductInput.equalsIgnoreCase(depot[i].getProduct0().getProductName())){
                            System.out.println(depot[i].getProduct0().getProductName()+" was chosen. It currently has a quantity of "+depot[i].getProduct0().getProductQuantity()+".");
                            System.out.println("How many items of this Product would you like to remove: ");
                            int removeQuantity = console.nextInt();
                            while (removeQuantity > depot[i].getProduct0().getProductQuantity()){
                                System.out.println("ERROR: This is higher than the quantity existing for the product.");
                                System.out.println("Please enter a value less than or equal to "+depot[i].getProduct0().getProductQuantity()+".");
                                removeQuantity = console.nextInt();
                            }
                            depot[i].getProduct0().setProductQuantity(depot[i].getProduct0().getProductQuantity()-removeQuantity);
                            System.out.println("The quantity of "+depot[i].getProduct0().getProductName()+" is now "+depot[i].getProduct0().getProductQuantity()+".");
                            if (depot[i].getProduct0().getProductQuantity() == 0){
                                System.out.println(depot[i].getProduct0().getProductName()+" was removed due to 0 quantity.");
                                depot[i].setProduct0(null);
                            }
                        } else {
                            invalidProduct++;
                        }
                    } catch (Exception e){
                        invalidProduct++;
                    }
                    //try for product1 of depot[i] that was selected
                    try {
                        if (tempProductInput.equalsIgnoreCase(depot[i].getProduct1().getProductName())){
                            System.out.println(depot[i].getProduct1().getProductName()+" was chosen. It currently has a quantity of "+depot[i].getProduct1().getProductQuantity()+".");
                            System.out.println("How many items of this Product would you like to remove: ");
                            int removeQuantity = console.nextInt();
                            while (removeQuantity > depot[i].getProduct1().getProductQuantity()){
                                System.out.println("ERROR: This is higher than the quantity existing for the product.");
                                System.out.println("Please enter a value less than or equal to "+depot[i].getProduct1().getProductQuantity()+".");
                                removeQuantity = console.nextInt();
                            }
                            depot[i].getProduct1().setProductQuantity(depot[i].getProduct1().getProductQuantity()-removeQuantity);
                            System.out.println("The quantity of "+depot[i].getProduct1().getProductName()+" is now "+depot[i].getProduct1().getProductQuantity()+".");
                            if (depot[i].getProduct1().getProductQuantity() == 0){
                                System.out.println(depot[i].getProduct1().getProductName()+" was removed due to 0 quantity.");
                                depot[i].setProduct1(null);
                            }
                        } else {
                            invalidProduct++;
                        }
                    } catch (Exception e){
                        invalidProduct++;
                    }
                    //try for product2 of depot[i] that was selected
                    try {
                        if (tempProductInput.equalsIgnoreCase(depot[i].getProduct2().getProductName())){
                            System.out.println(depot[i].getProduct2().getProductName()+" was chosen. It currently has a quantity of "+depot[i].getProduct2().getProductQuantity()+".");
                            System.out.println("How many items of this Product would you like to remove: ");
                            int removeQuantity = console.nextInt();
                            while (removeQuantity > depot[i].getProduct2().getProductQuantity()){
                                System.out.println("ERROR: This is higher than the quantity existing for the product.");
                                System.out.println("Please enter a value less than or equal to "+depot[i].getProduct2().getProductQuantity()+".");
                                removeQuantity = console.nextInt();
                            }
                            depot[i].getProduct2().setProductQuantity(depot[i].getProduct2().getProductQuantity()-removeQuantity);
                            System.out.println("The quantity of "+depot[i].getProduct2().getProductName()+" is now "+depot[i].getProduct2().getProductQuantity()+".");
                            if (depot[i].getProduct2().getProductQuantity() == 0){
                                System.out.println(depot[i].getProduct2().getProductName()+" was removed due to 0 quantity.");
                                depot[i].setProduct2(null);
                            }
                        } else {
                            invalidProduct++;
                        }
                    } catch (Exception e){
                        invalidProduct++;
                    }
                    //try for product3 of depot[i] that was selected
                    try {
                        if (tempProductInput.equalsIgnoreCase(depot[i].getProduct3().getProductName())){
                            System.out.println(depot[i].getProduct3().getProductName()+" was chosen. It currently has a quantity of "+depot[i].getProduct3().getProductQuantity()+".");
                            System.out.println("How many items of this Product would you like to remove: ");
                            int removeQuantity = console.nextInt();
                            while (removeQuantity > depot[i].getProduct3().getProductQuantity()){
                                System.out.println("ERROR: This is higher than the quantity existing for the product.");
                                System.out.println("Please enter a value less than or equal to "+depot[i].getProduct3().getProductQuantity()+".");
                                removeQuantity = console.nextInt();
                            }
                            depot[i].getProduct3().setProductQuantity(depot[i].getProduct3().getProductQuantity()-removeQuantity);
                            System.out.println("The quantity of "+depot[i].getProduct3().getProductName()+" is now "+depot[i].getProduct3().getProductQuantity()+".");
                            if (depot[i].getProduct3().getProductQuantity() == 0){
                                System.out.println(depot[i].getProduct3().getProductName()+" was removed due to 0 quantity.");
                                depot[i].setProduct3(null);
                            }
                        } else {
                            invalidProduct++;
                        }
                    } catch (Exception e){
                        invalidProduct++;
                    }
                    //try for product4 of depot[i] that was selected
                    try {
                        if (tempProductInput.equalsIgnoreCase(depot[i].getProduct4().getProductName())){
                            System.out.println(depot[i].getProduct4().getProductName()+" was chosen. It currently has a quantity of "+depot[i].getProduct4().getProductQuantity()+".");
                            System.out.println("How many items of this Product would you like to remove: ");
                            int removeQuantity = console.nextInt();
                            while (removeQuantity > depot[i].getProduct4().getProductQuantity()){
                                System.out.println("ERROR: This is higher than the quantity existing for the product.");
                                System.out.println("Please enter a value less than or equal to "+depot[i].getProduct4().getProductQuantity()+".");
                                removeQuantity = console.nextInt();
                            }
                            depot[i].getProduct4().setProductQuantity(depot[i].getProduct4().getProductQuantity()-removeQuantity);
                            System.out.println("The quantity of "+depot[i].getProduct4().getProductName()+" is now "+depot[i].getProduct4().getProductQuantity()+".");
                            if (depot[i].getProduct4().getProductQuantity() == 0){
                                System.out.println(depot[i].getProduct4().getProductName()+" was removed due to 0 quantity.");
                                depot[i].setProduct4(null);
                            }
                        } else {
                            invalidProduct++;
                        }
                    } catch (Exception e){
                        invalidProduct++;
                    }
                    if (invalidProduct == 5)
                        System.out.println("ERROR: This Product does not exist!");
                } else {
                    doesNotExist++;
                }
            } catch (Exception e){
                doesNotExist++;
            }
        }
        if (doesNotExist == 4)
            System.out.println("ERROR: This Depot does not exist!");
    }

    private void listDepots(){
        int i,noDepots = 0;
        for (i=0;i<=3;i++){
            if (depot[i] != null){
                int productCount = 0;
                if (depot[i].getProduct0() != null)
                    productCount++;
                if (depot[i].getProduct1() != null)
                    productCount++;
                if (depot[i].getProduct2() != null)
                    productCount++;
                if (depot[i].getProduct3() != null)
                    productCount++;
                if (depot[i].getProduct4() != null)
                    productCount++;
                System.out.println(depot[i].getDepotName()+" currently has "+productCount+" products.");
            } else {
                noDepots++;
            }
        }
        if (noDepots == 4)
            System.out.println("ERROR: No Depots currently exist!");
    }

    private void listProducts(){
        System.out.println("Enter name of Depot: ");
        String tempDepotInput = console.next();
        int i, noMatch = 0;
        for (i=0;i<=3;i++){
            try {
                if (tempDepotInput.equalsIgnoreCase(depot[i].getDepotName())){
                    System.out.println(depot[i].getDepotName()+" was chosen.");
                    int noProducts = 0;
                    //for product0
                    try {
                        System.out.println(depot[i].getProduct0().getProductName()+" has price $"+depot[i].getProduct0().getProductPrice()+
                                ", weight "+depot[i].getProduct0().getProductWeight()+"kg, and quantity "+depot[i].getProduct0().getProductQuantity()+".");
                    } catch (Exception e){
                        noProducts++;
                    }
                    //for product1
                    try {
                        System.out.println(depot[i].getProduct1().getProductName()+" has price $"+depot[i].getProduct1().getProductPrice()+
                                ", weight "+depot[i].getProduct1().getProductWeight()+"kg, and quantity "+depot[i].getProduct1().getProductQuantity()+".");
                    } catch (Exception e){
                        noProducts++;
                    }
                    //for product2
                    try {
                        System.out.println(depot[i].getProduct2().getProductName()+" has price $"+depot[i].getProduct2().getProductPrice()+
                                ", weight "+depot[i].getProduct2().getProductWeight()+"kg, and quantity "+depot[i].getProduct2().getProductQuantity()+".");
                    } catch (Exception e){
                        noProducts++;
                    }
                    //for product3
                    try {
                        System.out.println(depot[i].getProduct3().getProductName()+" has price $"+depot[i].getProduct3().getProductPrice()+
                                ", weight "+depot[i].getProduct3().getProductWeight()+"kg, and quantity "+depot[i].getProduct3().getProductQuantity()+".");
                    } catch (Exception e){
                        noProducts++;
                    }
                    //for product 4
                    try {
                        System.out.println(depot[i].getProduct4().getProductName()+" has price $"+depot[i].getProduct4().getProductPrice()+
                                ", weight "+depot[i].getProduct4().getProductWeight()+"kg, and quantity "+depot[i].getProduct4().getProductQuantity()+".");
                    } catch (Exception e){
                        noProducts++;
                    }
                    //if no products exist, it only prints this line
                    if (noProducts == 5)
                        System.out.println(depot[i].getDepotName()+" exists but has no Products.");
                } else {
                    noMatch++;
                }
            } catch (Exception e){
                noMatch++;
            }
        }
        if (noMatch == 4){
            System.out.println("ERROR: This depot does not exist!");
        }
    }

    private void searchForProduct(){
        System.out.println("Enter name of a Product: ");
        String productSearch = console.next();
        int i, noProductMatch = 0;
        for (i=0;i<=3;i++){
            //product0
            try {
                if (productSearch.equalsIgnoreCase(depot[i].getProduct0().getProductName())){
                    System.out.println(depot[i].getProduct0().getProductName()+" is in "+depot[i].getDepotName()+" with quantity "+depot[i].getProduct0().getProductQuantity()+".");
                } else {
                    noProductMatch++;
                }
            } catch (Exception e){
                noProductMatch++;
            }
            //product1
            try {
                if (productSearch.equalsIgnoreCase(depot[i].getProduct1().getProductName())){
                    System.out.println(depot[i].getProduct1().getProductName()+" is in "+depot[i].getDepotName()+" with quantity "+depot[i].getProduct1().getProductQuantity()+".");
                } else {
                    noProductMatch++;
                }
            } catch (Exception e){
                noProductMatch++;
            }
            //product2
            try {
                if (productSearch.equalsIgnoreCase(depot[i].getProduct2().getProductName())){
                    System.out.println(depot[i].getProduct2().getProductName()+" is in "+depot[i].getDepotName()+" with quantity "+depot[i].getProduct2().getProductQuantity()+".");
                } else {
                    noProductMatch++;
                }
            } catch (Exception e){
                noProductMatch++;
            }
            //product3
            try {
                if (productSearch.equalsIgnoreCase(depot[i].getProduct3().getProductName())){
                    System.out.println(depot[i].getProduct3().getProductName()+" is in "+depot[i].getDepotName()+" with quantity "+depot[i].getProduct3().getProductQuantity()+".");
                } else {
                    noProductMatch++;
                }
            } catch (Exception e){
                noProductMatch++;
            }
            //product4
            try {
                if (productSearch.equalsIgnoreCase(depot[i].getProduct4().getProductName())){
                    System.out.println(depot[i].getProduct4().getProductName()+" is in "+depot[i].getDepotName()+" with quantity "+depot[i].getProduct4().getProductQuantity()+".");
                } else {
                    noProductMatch++;
                }
            } catch (Exception e){
                noProductMatch++;
            }
        }
        if (noProductMatch == 20){
            System.out.println("ERROR: No Product exists with this name!");
        }
    }

    private void cumulativeValue(){
        System.out.print("Enter a Depot name: ");
        String tempDepotInput = console.next();
        int i,doesNotExist = 0;
        double totalValue = 0;
        for (i=0;i<=3;i++){
            try {
                if (tempDepotInput.equalsIgnoreCase(depot[i].getDepotName())){
                    if (depot[i].getProduct0() != null)
                        totalValue += depot[i].getProduct0().getProductQuantity()*depot[i].getProduct0().getProductPrice();
                    if (depot[i].getProduct1() != null)
                        totalValue += depot[i].getProduct1().getProductQuantity()*depot[i].getProduct1().getProductPrice();
                    if (depot[i].getProduct2() != null)
                        totalValue += depot[i].getProduct2().getProductQuantity()*depot[i].getProduct2().getProductPrice();
                    if (depot[i].getProduct3() != null)
                        totalValue += depot[i].getProduct3().getProductQuantity()*depot[i].getProduct3().getProductPrice();
                    if (depot[i].getProduct4() != null)
                        totalValue += depot[i].getProduct4().getProductQuantity()*depot[i].getProduct4().getProductPrice();

                    System.out.println(depot[i].getDepotName()+" has a cumulative value of $"+totalValue+".");
                } else {
                    doesNotExist++;
                }
            } catch (Exception e){
                doesNotExist++;
            }


        }
        if (doesNotExist == 4)
            System.out.println("ERROR: This Depot does not exist!");
    }

    private void exportFile()throws Exception{
        System.out.println("Please name the file to export (add .txt if you wish): ");
        String fileName = console.next();
        PrintWriter outFile = new PrintWriter(fileName);

        //make it so the file always puts the depot name then
        //puts <depot> <product> <price> <weight> <quantity> for each existing product
        //in that depot
        int i;
        for (i=0;i<=3;i++){
            if (depot[i] != null) {
                if (depot[i].getProduct0() != null){
                    outFile.println(depot[i].getDepotName() + " " + depot[i].getProduct0().getProductName() + " " + depot[i].getProduct0().getProductPrice() + " " +
                            depot[i].getProduct0().getProductWeight() + " " + depot[i].getProduct0().getProductQuantity());
                }
                if (depot[i].getProduct1() != null){
                    outFile.println(depot[i].getDepotName() + " " + depot[i].getProduct1().getProductName() + " " + depot[i].getProduct1().getProductPrice() + " " +
                            depot[i].getProduct1().getProductWeight() + " " + depot[i].getProduct1().getProductQuantity());
                }
                if (depot[i].getProduct2() != null){
                    outFile.println(depot[i].getDepotName() + " " + depot[i].getProduct2().getProductName() + " " + depot[i].getProduct2().getProductPrice() + " " +
                            depot[i].getProduct2().getProductWeight() + " " + depot[i].getProduct2().getProductQuantity());
                }
                if (depot[i].getProduct3() != null){
                    outFile.println(depot[i].getDepotName() + " " + depot[i].getProduct3().getProductName() + " " + depot[i].getProduct3().getProductPrice() + " " +
                            depot[i].getProduct3().getProductWeight() + " " + depot[i].getProduct3().getProductQuantity());
                }
                if (depot[i].getProduct4() != null){
                    outFile.println(depot[i].getDepotName() + " " + depot[i].getProduct4().getProductName() + " " + depot[i].getProduct4().getProductPrice() + " " +
                            depot[i].getProduct4().getProductWeight() + " " + depot[i].getProduct4().getProductQuantity());
                }
            }
        }
        outFile.close();
        System.out.println("Exported successfully!");
    }

    private void importFile()throws Exception {
        System.out.println("Specify path of file to import (include file extension): ");
        String fileName = console.next();
        Scanner inputStream = new Scanner(new File(fileName));

        //this will input one depot at a time
        //need to check if the depot is already in place e.g. if this program is scanning
        //the second line, a different product may be listed but for the same depot
        try {
            while (inputStream.hasNextLine()) {
                //first just takes all the values for that line to store
                int i, j, addNewDepot = 0;
                String depotName = inputStream.next();
                String productName = inputStream.next();
                double productPrice = inputStream.nextDouble();
                double productWeight = inputStream.nextDouble();
                int productQuantity = inputStream.nextInt();
                //then check if the depot exists

                for (i = 0; i <= 3; i++) {
                    if (depot[i] != null) {
                        if (depot[i].getDepotName().equalsIgnoreCase(depotName)) {
                            for (j = 0; j <= 3; j++) {
                                //checks all depots to see if a product already exists with similar features, if it does they are copied
                                if (depot[j] != null) {
                                    if (depot[j].getProduct0() != null) {
                                        if (depot[j].getProduct0().getProductName().equalsIgnoreCase(productName)) {
                                            productPrice = depot[j].getProduct0().getProductPrice();
                                            productWeight = depot[j].getProduct0().getProductWeight();
                                        }
                                    }
                                    if (depot[j].getProduct1() != null) {
                                        if (depot[j].getProduct1().getProductName().equalsIgnoreCase(productName)) {
                                            productPrice = depot[j].getProduct1().getProductPrice();
                                            productWeight = depot[j].getProduct1().getProductWeight();
                                        }
                                    }
                                    if (depot[j].getProduct2() != null) {
                                        if (depot[j].getProduct2().getProductName().equalsIgnoreCase(productName)) {
                                            productPrice = depot[j].getProduct2().getProductPrice();
                                            productWeight = depot[j].getProduct2().getProductWeight();
                                        }
                                    }
                                    if (depot[j].getProduct3() != null) {
                                        if (depot[j].getProduct3().getProductName().equalsIgnoreCase(productName)) {
                                            productPrice = depot[j].getProduct3().getProductPrice();
                                            productWeight = depot[j].getProduct3().getProductWeight();
                                        }
                                    }
                                    if (depot[j].getProduct4() != null) {
                                        if (depot[j].getProduct4().getProductName().equalsIgnoreCase(productName)) {
                                            productPrice = depot[j].getProduct4().getProductPrice();
                                            productWeight = depot[j].getProduct4().getProductWeight();
                                        }
                                    }
                                }
                            }
                            //now that features have been copied, add product into spare spot, if it cant fit give an error saying there was no room for one or more products
                            if (depot[i].getProduct0() == null) {
                                depot[i].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                            } else if (depot[i].getProduct1() == null) {
                                depot[i].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                            } else if (depot[i].getProduct2() == null) {
                                depot[i].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                            } else if (depot[i].getProduct3() == null) {
                                depot[i].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                            } else if (depot[i].getProduct4() == null) {
                                depot[i].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                            } else {
                                System.out.println("ERROR: A product could not be added, there was not enough space in " + depot[i].getDepotName() + ".");
                            }
                        } else {
                            addNewDepot++;
                        }
                    } else {
                        addNewDepot++;
                    }
                }
                //if the depot did not exist it adds this way...
                if (addNewDepot == 4) {
                    int p = 0;
                    if (depot[0] == null) {
                        depot[0] = new Depot(depotName);
                        p = 0;
                    } else if (depot[1] == null) {
                        depot[1] = new Depot(depotName);
                        p = 1;
                    } else if (depot[2] == null) {
                        depot[2] = new Depot(depotName);
                        p = 2;
                    } else if (depot[3] == null) {
                        depot[3] = new Depot(depotName);
                        p = 3;
                    }
                    /**
                     * Now the program just adds like above
                     */
                    for (j = 0; j <= 3; j++) {
                        //checks all depots to see if a product already exists with similar features, if it does they are copied
                        if (depot[j] != null) {
                            if (depot[j].getProduct0() != null) {
                                if (depot[j].getProduct0().getProductName().equalsIgnoreCase(productName)) {
                                    productPrice = depot[j].getProduct0().getProductPrice();
                                    productWeight = depot[j].getProduct0().getProductWeight();
                                }
                            }
                            if (depot[j].getProduct1() != null) {
                                if (depot[j].getProduct1().getProductName().equalsIgnoreCase(productName)) {
                                    productPrice = depot[j].getProduct1().getProductPrice();
                                    productWeight = depot[j].getProduct1().getProductWeight();
                                }
                            }
                            if (depot[j].getProduct2() != null) {
                                if (depot[j].getProduct2().getProductName().equalsIgnoreCase(productName)) {
                                    productPrice = depot[j].getProduct2().getProductPrice();
                                    productWeight = depot[j].getProduct2().getProductWeight();
                                }
                            }
                            if (depot[j].getProduct3() != null) {
                                if (depot[j].getProduct3().getProductName().equalsIgnoreCase(productName)) {
                                    productPrice = depot[j].getProduct3().getProductPrice();
                                    productWeight = depot[j].getProduct3().getProductWeight();
                                }
                            }
                            if (depot[j].getProduct4() != null) {
                                if (depot[j].getProduct4().getProductName().equalsIgnoreCase(productName)) {
                                    productPrice = depot[j].getProduct4().getProductPrice();
                                    productWeight = depot[j].getProduct4().getProductWeight();
                                }
                            }
                        }
                    }
                    //now that features have been copied, add product into spare spot, if it cant fit give an error saying there was no room for one or more products
                    if (depot[p].getProduct0() == null) {
                        depot[p].setProduct0(new Product(productName, productPrice, productWeight, productQuantity));
                    } else if (depot[p].getProduct1() == null) {
                        depot[p].setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                    } else if (depot[p].getProduct2() == null) {
                        depot[p].setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                    } else if (depot[p].getProduct3() == null) {
                        depot[p].setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                    } else if (depot[p].getProduct4() == null) {
                        depot[p].setProduct4(new Product(productName, productPrice, productWeight, productQuantity));
                    } else {
                        System.out.println("ERROR: A product could not be added, there was not enough space in " + depot[i].getDepotName() + ".");
                    }
                }
            }
            inputStream.close();
        } catch (Exception e){
            System.out.println("Import Successful!");
        }
    }

   //add other methods

}