//c3315176 - Jeremy Anderson
import java.util.*;

public class Interface
{
    static Scanner console = new Scanner(System.in);
    private Depot depot1 = null;
    private Depot depot2 = null;
    private int option;

    public void run()
    {
        do{
            System.out.println("[0. Exit]");
            System.out.println("[1. Add Depot]");
            System.out.println("[2. Remove Depot]");
            System.out.println("[3. Add Product Item]");
            System.out.println("[4. Remove Product Item]");
            System.out.println("[5. List Depots]");
            System.out.println("[6. List Products]");
            System.out.println("[7. Show Product Info]");
            System.out.println("[8. Get Cumulative Value of Depot]");
            System.out.println("Choose an option listed above: ");
            option = console.nextInt();

            switch(option)
            {
                default: System.out.println("ERROR: Invalid input, please try again!");

                case 0: break;

                case 1: //Add Depot
                    if (depot1 == null || depot2 == null){
                        System.out.println("DEPOT NAME: ");
                        String tempDepotInput = console.next();
                        if (depot1 == null){
                            if (depot2 != null) {
                                if (!tempDepotInput.equalsIgnoreCase(depot2.getDepotName())) {
                                    depot1 = new Depot(tempDepotInput.toLowerCase());
                                    System.out.println(depot1.getDepotName()+" was created.");
                                } else {
                                    System.out.println("ERROR: Depot name already exists!");
                                }
                            } else {
                                depot1 = new Depot(tempDepotInput.toLowerCase());
                                System.out.println(depot1.getDepotName()+" was created.");
                            }
                        } else if (depot2 == null) {
                            if (!tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                depot2 = new Depot(tempDepotInput.toLowerCase());
                                System.out.println(depot2.getDepotName() + " was created.");
                            } else {
                                System.out.println("ERROR: Depot name already exists!");
                            }
                        }
                    } else {
                        System.out.println("ERROR: Two depots already exists!");
                    }
                    break;

                case 2: //Remove Depot
                    if (depot1 != null || depot2 != null){
                        System.out.println("DEPOT NAME: ");
                        String tempDepotInput = console.next();
                        if (depot1 != null && depot2 != null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())){
                                System.out.println(depot1.getDepotName()+" was removed.");
                                depot1 = null;
                            } else if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())){
                                System.out.println(depot2.getDepotName()+" was removed.");
                                depot2 = null;
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else if (depot2 == null) {
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                System.out.println(depot1.getDepotName() + " was removed.");
                                depot1 = null;
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else {
                            if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())) {
                                System.out.println(depot2.getDepotName() + " was removed.");
                                depot2 = null;
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        }
                    } else {
                        System.out.println("ERROR: No depots currently exist!");
                    }
                    break;

                case 3: //Add Product Item
                    /**
                     * individually checks if each products exists in either depot,
                     * if a product shares the same name as the input, it uses existing information to form the product
                     * if not it creates it manually
                     */
                    if ((depot1 != null) || (depot2 != null)){
                        System.out.println("DEPOT NAME: ");
                        String tempDepotInput = console.next();
                        if (depot2 != null && depot1!= null) {
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                System.out.println(depot1.getDepotName() + " was chosen.");

                                System.out.println("PRODUCT NAME: ");
                                String productName = console.next();

                                /**
                                 * BELOW, if the product exists in the already selected depot, it will replace it
                                 */
                                if (depot1.getProduct1() != null){
                                    if (productName.equalsIgnoreCase(depot1.getProduct1().getProductName())){
                                        System.out.println(depot1.getProduct1().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct1().getProductPrice()+" and weighs "+depot1.getProduct1().getProductWeight()+"KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot1.getProduct1().setProductQuantity(productQuantity);
                                        System.out.println(depot1.getProduct1().getProductName()+" now has a quantity of "+depot1.getProduct1().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot1.getProduct2() != null) {
                                    if (productName.equalsIgnoreCase(depot1.getProduct2().getProductName())){
                                        System.out.println(depot1.getProduct2().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $" + depot1.getProduct2().getProductPrice() + " and weighs " + depot1.getProduct2().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot1.getProduct2().setProductQuantity(productQuantity);
                                        System.out.println(depot1.getProduct2().getProductName()+" now has a quantity of "+depot1.getProduct2().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot1.getProduct3() != null){
                                    if (productName.equalsIgnoreCase(depot1.getProduct3().getProductName())){
                                        System.out.println(depot1.getProduct3().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct3().getProductPrice() + " and weighs " + depot1.getProduct3().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot1.getProduct3().setProductQuantity(productQuantity);
                                        System.out.println(depot1.getProduct3().getProductName()+" now has a quantity of "+depot1.getProduct3().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                /**
                                 * BELOW, if already in a different depot, uses the exiting information to create the new product
                                 */
                                if (depot2.getProduct1() != null){
                                    if (productName.equalsIgnoreCase(depot2.getProduct1().getProductName())){
                                        System.out.println(depot2.getProduct1().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct1().getProductPrice()+" and weighs "+depot2.getProduct1().getProductWeight()+"KG! Using the existing information to create a new product, enter a quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (depot1.getProduct1() == null) {
                                            depot1.setProduct1(new Product(productName, depot2.getProduct1().getProductPrice(), depot2.getProduct1().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct1().getProductName() + " is a new product, with a quantity of " + depot1.getProduct1().getProductQuantity());
                                        } else if (depot1.getProduct2() == null) {
                                            depot1.setProduct2(new Product(productName, depot2.getProduct1().getProductPrice(), depot2.getProduct1().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct2().getProductName() + " is a new product, with a quantity of " + depot1.getProduct2().getProductQuantity());
                                        } else if (depot1.getProduct3() == null) {
                                            depot1.setProduct3(new Product(productName, depot2.getProduct1().getProductPrice(), depot2.getProduct1().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct3().getProductName() + " is a new product, with a quantity of " + depot1.getProduct3().getProductQuantity());
                                        } else {
                                            System.out.println("ERROR: 3 products already exist for " + depot1.getDepotName() + "!");
                                        }
                                        break;
                                    }
                                }
                                if (depot2.getProduct2() != null) {
                                    if (productName.equalsIgnoreCase(depot2.getProduct2().getProductName())){
                                        System.out.println(depot2.getProduct2().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct2().getProductPrice()+" and weighs "+depot2.getProduct2().getProductWeight()+"KG! Using the existing information to create a new product, enter a quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (depot1.getProduct1() == null) {
                                            depot1.setProduct1(new Product(productName, depot2.getProduct2().getProductPrice(), depot2.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct1().getProductName() + " is a new product, with a quantity of " + depot1.getProduct1().getProductQuantity());
                                        } else if (depot1.getProduct2() == null) {
                                            depot1.setProduct2(new Product(productName, depot2.getProduct2().getProductPrice(), depot2.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct2().getProductName() + " is a new product, with a quantity of " + depot1.getProduct2().getProductQuantity());
                                        } else if (depot1.getProduct3() == null) {
                                            depot1.setProduct3(new Product(productName, depot2.getProduct2().getProductPrice(), depot2.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct3().getProductName() + " is a new product, with a quantity of " + depot1.getProduct3().getProductQuantity());
                                        } else {
                                            System.out.println("ERROR: 3 products already exist for " + depot1.getDepotName() + "!");
                                        }
                                        break;
                                    }
                                }
                                if (depot2.getProduct3() != null) {
                                    if (productName.equalsIgnoreCase(depot2.getProduct3().getProductName())){
                                        System.out.println(depot2.getProduct3().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct3().getProductPrice()+" and weighs "+depot2.getProduct2().getProductWeight()+"KG! Using the existing information to create a new product, enter a quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (depot1.getProduct1() == null) {
                                            depot1.setProduct1(new Product(productName, depot2.getProduct2().getProductPrice(), depot2.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct1().getProductName() + " is a new product, with a quantity of " + depot1.getProduct1().getProductQuantity());
                                        } else if (depot1.getProduct2() == null) {
                                            depot1.setProduct2(new Product(productName, depot2.getProduct2().getProductPrice(), depot2.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct2().getProductName() + " is a new product, with a quantity of " + depot1.getProduct2().getProductQuantity());
                                        } else if (depot1.getProduct3() == null) {
                                            depot1.setProduct3(new Product(productName, depot2.getProduct2().getProductPrice(), depot2.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot1.getProduct3().getProductName() + " is a new product, with a quantity of " + depot1.getProduct3().getProductQuantity());
                                        } else {
                                            System.out.println("ERROR: 3 products already exist for " + depot1.getDepotName() + "!");
                                        }
                                        break;
                                    }
                                }

                                /**
                                 * if the above failed for all 3 products in both depots, adds a product normally to selected depot
                                 */

                                System.out.println("PRODUCT PRICE: $");
                                double productPrice = console.nextDouble();
                                while (productPrice <= 0) {
                                    System.out.println("ERROR: The price must be positive, please enter a new price!");
                                    productPrice = console.nextDouble();
                                }

                                System.out.println("PRODUCT WEIGHT: ");
                                double productWeight = console.nextDouble();
                                while (productWeight <= 0) {
                                    System.out.println("ERROR: The weight must be positive, please enter a new weight!");
                                    productWeight = console.nextDouble();
                                }

                                System.out.println("PRODUCT QUANTITY: ");
                                int productQuantity = console.nextInt();
                                while (productQuantity <= 0) {
                                    System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                    productQuantity = console.nextInt();
                                }

                                if (depot1.getProduct1() == null) {
                                    depot1.setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot1.getProduct1().getProductName() + " is a new product, with a quantity of " + depot1.getProduct1().getProductQuantity());
                                } else if (depot1.getProduct2() == null) {
                                    depot1.setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot1.getProduct2().getProductName() + " is a new product, with a quantity of " + depot1.getProduct2().getProductQuantity());
                                } else if (depot1.getProduct3() == null) {
                                    depot1.setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot1.getProduct3().getProductName() + " is a new product, with a quantity of " + depot1.getProduct3().getProductQuantity());
                                } else {
                                    System.out.println("ERROR: 3 products already exist for " + depot1.getDepotName() + "!");
                                }
                            } else if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())) {
                                System.out.println(depot1.getDepotName() + " was chosen.");

                                System.out.println("PRODUCT NAME: ");
                                String productName = console.next();

                                /**
                                 * BELOW, if the product exists in the already selected depot, it will replace it
                                 */
                                if (depot2.getProduct1() != null){
                                    if (productName.equalsIgnoreCase(depot2.getProduct1().getProductName())){
                                        System.out.println(depot2.getProduct1().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct1().getProductPrice()+" and weighs "+depot2.getProduct1().getProductWeight()+"KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot2.getProduct1().setProductQuantity(productQuantity);
                                        System.out.println(depot2.getProduct1().getProductName()+" now has a quantity of "+depot2.getProduct1().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot2.getProduct2() != null) {
                                    if (productName.equalsIgnoreCase(depot2.getProduct2().getProductName())){
                                        System.out.println(depot2.getProduct2().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $" + depot2.getProduct2().getProductPrice() + " and weighs " + depot2.getProduct2().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot2.getProduct2().setProductQuantity(productQuantity);
                                        System.out.println(depot2.getProduct2().getProductName()+" now has a quantity of "+depot2.getProduct2().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot2.getProduct3() != null){
                                    if (productName.equalsIgnoreCase(depot2.getProduct3().getProductName())){
                                        System.out.println(depot2.getProduct3().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct3().getProductPrice() + " and weighs " + depot2.getProduct3().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot2.getProduct3().setProductQuantity(productQuantity);
                                        System.out.println(depot2.getProduct3().getProductName()+" now has a quantity of "+depot2.getProduct3().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                /**
                                 * BELOW, if already in a different depot, uses the exiting information to create the new product
                                 */
                                if (depot1.getProduct1() != null){
                                    if (productName.equalsIgnoreCase(depot1.getProduct1().getProductName())){
                                        System.out.println(depot1.getProduct1().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct1().getProductPrice()+" and weighs "+depot1.getProduct1().getProductWeight()+"KG! Using the existing information to create a new product, enter a quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (depot2.getProduct1() == null) {
                                            depot2.setProduct1(new Product(productName, depot1.getProduct1().getProductPrice(), depot1.getProduct1().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct1().getProductName() + " is a new product, with a quantity of " + depot2.getProduct1().getProductQuantity());
                                        } else if (depot2.getProduct2() == null) {
                                            depot2.setProduct2(new Product(productName, depot1.getProduct1().getProductPrice(), depot1.getProduct1().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct2().getProductName() + " is a new product, with a quantity of " + depot2.getProduct2().getProductQuantity());
                                        } else if (depot2.getProduct3() == null) {
                                            depot2.setProduct3(new Product(productName, depot1.getProduct1().getProductPrice(), depot1.getProduct1().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct3().getProductName() + " is a new product, with a quantity of " + depot2.getProduct3().getProductQuantity());
                                        } else {
                                            System.out.println("ERROR: 3 products already exist for " + depot2.getDepotName() + "!");
                                        }
                                        break;
                                    }
                                }
                                if (depot1.getProduct2() != null) {
                                    if (productName.equalsIgnoreCase(depot1.getProduct2().getProductName())){
                                        System.out.println(depot1.getProduct2().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct2().getProductPrice()+" and weighs "+depot1.getProduct2().getProductWeight()+"KG! Using the existing information to create a new product, enter a quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (depot2.getProduct1() == null) {
                                            depot2.setProduct1(new Product(productName, depot1.getProduct2().getProductPrice(), depot1.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct1().getProductName() + " is a new product, with a quantity of " + depot2.getProduct1().getProductQuantity());
                                        } else if (depot2.getProduct2() == null) {
                                            depot2.setProduct2(new Product(productName, depot1.getProduct2().getProductPrice(), depot1.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct2().getProductName() + " is a new product, with a quantity of " + depot2.getProduct2().getProductQuantity());
                                        } else if (depot2.getProduct3() == null) {
                                            depot2.setProduct3(new Product(productName, depot1.getProduct2().getProductPrice(), depot1.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct3().getProductName() + " is a new product, with a quantity of " + depot2.getProduct3().getProductQuantity());
                                        } else {
                                            System.out.println("ERROR: 3 products already exist for " + depot2.getDepotName() + "!");
                                        }
                                        break;
                                    }
                                }
                                if (depot1.getProduct3() != null) {
                                    if (productName.equalsIgnoreCase(depot1.getProduct3().getProductName())){
                                        System.out.println(depot1.getProduct3().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct3().getProductPrice()+" and weighs "+depot1.getProduct2().getProductWeight()+"KG! Using the existing information to create a new product, enter a quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        if (depot2.getProduct1() == null) {
                                            depot2.setProduct1(new Product(productName, depot1.getProduct2().getProductPrice(), depot1.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct1().getProductName() + " is a new product, with a quantity of " + depot2.getProduct1().getProductQuantity());
                                        } else if (depot2.getProduct2() == null) {
                                            depot2.setProduct2(new Product(productName, depot1.getProduct2().getProductPrice(), depot1.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct2().getProductName() + " is a new product, with a quantity of " + depot2.getProduct2().getProductQuantity());
                                        } else if (depot2.getProduct3() == null) {
                                            depot2.setProduct3(new Product(productName, depot1.getProduct2().getProductPrice(), depot1.getProduct2().getProductWeight(), productQuantity));
                                            System.out.println(depot2.getProduct3().getProductName() + " is a new product, with a quantity of " + depot2.getProduct3().getProductQuantity());
                                        } else {
                                            System.out.println("ERROR: 3 products already exist for " + depot2.getDepotName() + "!");
                                        }
                                        break;
                                    }
                                }

                                /**
                                 * if the above failed for all 3 products in both depots, adds a product normally to selected depot
                                 */

                                System.out.println("PRODUCT PRICE: $");
                                double productPrice = console.nextDouble();
                                while (productPrice <= 0) {
                                    System.out.println("ERROR: The price must be positive, please enter a new price!");
                                    productPrice = console.nextDouble();
                                }

                                System.out.println("PRODUCT WEIGHT: ");
                                double productWeight = console.nextDouble();
                                while (productWeight <= 0) {
                                    System.out.println("ERROR: The weight must be positive, please enter a new weight!");
                                    productWeight = console.nextDouble();
                                }

                                System.out.println("PRODUCT QUANTITY: ");
                                int productQuantity = console.nextInt();
                                while (productQuantity <= 0) {
                                    System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                    productQuantity = console.nextInt();
                                }

                                if (depot2.getProduct1() == null) {
                                    depot2.setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot2.getProduct1().getProductName() + " is a new product, with a quantity of " + depot2.getProduct1().getProductQuantity());
                                } else if (depot2.getProduct2() == null) {
                                    depot2.setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot2.getProduct2().getProductName() + " is a new product, with a quantity of " + depot2.getProduct2().getProductQuantity());
                                } else if (depot2.getProduct3() == null) {
                                    depot2.setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot2.getProduct3().getProductName() + " is a new product, with a quantity of " + depot2.getProduct3().getProductQuantity());
                                } else {
                                    System.out.println("ERROR: 3 products already exist for " + depot2.getDepotName() + "!");
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else if (depot1 == null) {
                            if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())) {
                                System.out.println(depot2.getDepotName() + " was chosen.");

                                System.out.println("PRODUCT NAME: ");
                                String productName = console.next();

                                /**
                                 * BELOW, if the product exists in the already selected depot, it will replace it
                                 */
                                if (depot2.getProduct1() != null){
                                    if (productName.equalsIgnoreCase(depot2.getProduct1().getProductName())){
                                        System.out.println(depot2.getProduct1().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct1().getProductPrice()+" and weighs "+depot2.getProduct1().getProductWeight()+"KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot2.getProduct1().setProductQuantity(productQuantity);
                                        System.out.println(depot2.getProduct1().getProductName()+" now has a quantity of "+depot2.getProduct1().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot2.getProduct2() != null) {
                                    if (productName.equalsIgnoreCase(depot2.getProduct2().getProductName())){
                                        System.out.println(depot2.getProduct2().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $" + depot2.getProduct2().getProductPrice() + " and weighs " + depot2.getProduct2().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot2.getProduct2().setProductQuantity(productQuantity);
                                        System.out.println(depot2.getProduct2().getProductName()+" now has a quantity of "+depot2.getProduct2().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot2.getProduct3() != null){
                                    if (productName.equalsIgnoreCase(depot2.getProduct3().getProductName())){
                                        System.out.println(depot2.getProduct3().getProductName()+" already exists in "+depot2.getDepotName()+", it costs $"+depot2.getProduct3().getProductPrice() + " and weighs " + depot2.getProduct3().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot2.getProduct3().setProductQuantity(productQuantity);
                                        System.out.println(depot2.getProduct3().getProductName()+" now has a quantity of "+depot2.getProduct3().getProductQuantity()+"!");
                                        break;
                                    }
                                }

                                /**
                                 * if the above failed for all 3 products in both depots, adds a product normally to selected depot
                                 */

                                System.out.println("PRODUCT PRICE: $");
                                double productPrice = console.nextDouble();
                                while (productPrice <= 0) {
                                    System.out.println("ERROR: The price must be positive, please enter a new price!");
                                    productPrice = console.nextDouble();
                                }

                                System.out.println("PRODUCT WEIGHT: ");
                                double productWeight = console.nextDouble();
                                while (productWeight <= 0) {
                                    System.out.println("ERROR: The weight must be positive, please enter a new weight!");
                                    productWeight = console.nextDouble();
                                }

                                System.out.println("PRODUCT QUANTITY: ");
                                int productQuantity = console.nextInt();
                                while (productQuantity <= 0) {
                                    System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                    productQuantity = console.nextInt();
                                }

                                if (depot2.getProduct1() == null) {
                                    depot2.setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot2.getProduct1().getProductName() + " is a new product, with a quantity of " + depot2.getProduct1().getProductQuantity());
                                } else if (depot2.getProduct2() == null) {
                                    depot2.setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot2.getProduct2().getProductName() + " is a new product, with a quantity of " + depot2.getProduct2().getProductQuantity());
                                } else if (depot2.getProduct3() == null) {
                                    depot2.setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot2.getProduct3().getProductName() + " is a new product, with a quantity of " + depot2.getProduct3().getProductQuantity());
                                } else {
                                    System.out.println("ERROR: 3 products already exist for " + depot2.getDepotName() + "!");
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else {
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                System.out.println(depot1.getDepotName() + " was chosen.");

                                System.out.println("PRODUCT NAME: ");
                                String productName = console.next();

                                /**
                                 * BELOW, if the product exists in the already selected depot, it will replace it
                                 */
                                if (depot1.getProduct1() != null){
                                    if (productName.equalsIgnoreCase(depot1.getProduct1().getProductName())){
                                        System.out.println(depot1.getProduct1().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct1().getProductPrice()+" and weighs "+depot1.getProduct1().getProductWeight()+"KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot1.getProduct1().setProductQuantity(productQuantity);
                                        System.out.println(depot1.getProduct1().getProductName()+" now has a quantity of "+depot1.getProduct1().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot1.getProduct2() != null) {
                                    if (productName.equalsIgnoreCase(depot1.getProduct2().getProductName())){
                                        System.out.println(depot1.getProduct2().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $" + depot1.getProduct2().getProductPrice() + " and weighs " + depot1.getProduct2().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot1.getProduct2().setProductQuantity(productQuantity);
                                        System.out.println(depot1.getProduct2().getProductName()+" now has a quantity of "+depot1.getProduct2().getProductQuantity()+"!");
                                        break;
                                    }
                                }
                                if (depot1.getProduct3() != null){
                                    if (productName.equalsIgnoreCase(depot1.getProduct3().getProductName())){
                                        System.out.println(depot1.getProduct3().getProductName()+" already exists in "+depot1.getDepotName()+", it costs $"+depot1.getProduct3().getProductPrice() + " and weighs " + depot1.getProduct3().getProductWeight() + "KG! Please enter a new quantity: ");
                                        int productQuantity = console.nextInt();
                                        while (productQuantity <= 0) {
                                            System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                            productQuantity = console.nextInt();
                                        }
                                        depot1.getProduct3().setProductQuantity(productQuantity);
                                        System.out.println(depot1.getProduct3().getProductName()+" now has a quantity of "+depot1.getProduct3().getProductQuantity()+"!");
                                        break;
                                    }
                                }

                                /**
                                 * if the above failed for all 3 products in both depots, adds a product normally to selected depot
                                 */

                                System.out.println("PRODUCT PRICE: $");
                                double productPrice = console.nextDouble();
                                while (productPrice <= 0) {
                                    System.out.println("ERROR: The price must be positive, please enter a new price!");
                                    productPrice = console.nextDouble();
                                }

                                System.out.println("PRODUCT WEIGHT: ");
                                double productWeight = console.nextDouble();
                                while (productWeight <= 0) {
                                    System.out.println("ERROR: The weight must be positive, please enter a new weight!");
                                    productWeight = console.nextDouble();
                                }

                                System.out.println("PRODUCT QUANTITY: ");
                                int productQuantity = console.nextInt();
                                while (productQuantity <= 0) {
                                    System.out.println("ERROR: The quantity must be positive, please enter a new quantity!");
                                    productQuantity = console.nextInt();
                                }

                                if (depot1.getProduct1() == null) {
                                    depot1.setProduct1(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot1.getProduct1().getProductName() + " is a new product, with a quantity of " + depot1.getProduct1().getProductQuantity());
                                } else if (depot1.getProduct2() == null) {
                                    depot1.setProduct2(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot1.getProduct2().getProductName() + " is a new product, with a quantity of " + depot1.getProduct2().getProductQuantity());
                                } else if (depot1.getProduct3() == null) {
                                    depot1.setProduct3(new Product(productName, productPrice, productWeight, productQuantity));
                                    System.out.println(depot1.getProduct3().getProductName() + " is a new product, with a quantity of " + depot1.getProduct3().getProductQuantity());
                                } else {
                                    System.out.println("ERROR: 3 products already exist for " + depot1.getDepotName() + "!");
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        }
                    } else {
                        System.out.println("ERROR: No depots currently exist!");
                    }
                    break;

                case 4: //Remove Product Item
                    /**
                     * checks if at least one depot exists, if it fails then it exits
                     * if at least on depot exists, it checks if each product in the depot exists and if it matches the input
                     * if no products exist, the counter reaches three printing an error
                     * if some or all products exist, but don't match the input, it prints an error
                     */
                    if (depot1 != null || depot2 != null){
                        System.out.println("CHOOSE DEPOT: ");
                        String tempDepotInput = console.next();
                        String tempProductInput;
                        int noProduct = 0;

                        if (depot1 != null && depot2 != null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())){
                                System.out.println(depot1.getDepotName()+" was chosen.");
                                System.out.println("PRODUCT NAME: ");
                                tempProductInput = console.next();

                                //check if input is product 1 in depot 1
                                if (depot1.getProduct1() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot1.getProduct1().getProductName())) {
                                        depot1.getProduct1().setProductQuantity(depot1.getProduct1().getProductQuantity() - 1);
                                        System.out.println(depot1.getProduct1().getProductName() + " now was a quantity of " + depot1.getProduct1().getProductQuantity() + ".");
                                        if (depot1.getProduct1().getProductQuantity() == 0) {
                                            System.out.println(depot1.getProduct1().getProductName() + " was removed.");
                                            depot1.setProduct1(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 2 in depot 1
                                if (depot1.getProduct2() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot1.getProduct2().getProductName())) {
                                        depot1.getProduct2().setProductQuantity(depot1.getProduct2().getProductQuantity() - 1);
                                        System.out.println(depot1.getProduct2().getProductName() + " now was a quantity of " + depot1.getProduct2().getProductQuantity() + ".");
                                        if (depot1.getProduct2().getProductQuantity() == 0) {
                                            System.out.println(depot1.getProduct2().getProductName() + " was removed.");
                                            depot1.setProduct2(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 3 in depot 1
                                if (depot1.getProduct3() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot1.getProduct3().getProductName())) {
                                        depot1.getProduct3().setProductQuantity(depot1.getProduct3().getProductQuantity() - 1);
                                        System.out.println(depot1.getProduct3().getProductName() + " now was a quantity of " + depot1.getProduct3().getProductQuantity() + ".");
                                        if (depot1.getProduct3().getProductQuantity() == 0) {
                                            System.out.println(depot1.getProduct3().getProductName() + " was removed.");
                                            depot1.setProduct1(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }

                            } else if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())){
                                System.out.println(depot2.getDepotName()+" was chosen.");
                                System.out.println("PRODUCT NAME: ");
                                tempProductInput = console.next();

                                //check if input is product 1 in depot 2
                                if (depot2.getProduct1() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot2.getProduct1().getProductName())) {
                                        depot2.getProduct1().setProductQuantity(depot2.getProduct1().getProductQuantity() - 1);
                                        System.out.println(depot2.getProduct1().getProductName() + " now was a quantity of " + depot1.getProduct1().getProductQuantity() + ".");
                                        if (depot2.getProduct1().getProductQuantity() == 0) {
                                            System.out.println(depot2.getProduct1().getProductName() + " was removed.");
                                            depot2.setProduct1(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 2 in depot 2
                                if (depot2.getProduct2() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot2.getProduct2().getProductName())) {
                                        depot2.getProduct2().setProductQuantity(depot2.getProduct2().getProductQuantity() - 1);
                                        System.out.println(depot2.getProduct2().getProductName() + " now was a quantity of " + depot1.getProduct2().getProductQuantity() + ".");
                                        if (depot2.getProduct2().getProductQuantity() == 0) {
                                            System.out.println(depot2.getProduct2().getProductName() + " was removed.");
                                            depot2.setProduct2(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 3 in depot 2
                                if (depot2.getProduct3() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot2.getProduct3().getProductName())) {
                                        depot2.getProduct3().setProductQuantity(depot2.getProduct3().getProductQuantity() - 1);
                                        System.out.println(depot2.getProduct3().getProductName() + " now was a quantity of " + depot1.getProduct3().getProductQuantity() + ".");
                                        if (depot2.getProduct3().getProductQuantity() == 0) {
                                            System.out.println(depot2.getProduct3().getProductName() + " was removed.");
                                            depot2.setProduct3(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }

                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                                noProduct = 4;
                            }

                        } else if (depot2 == null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                System.out.println(depot1.getDepotName() + " was chosen.");
                                System.out.println("PRODUCT NAME: ");
                                tempProductInput = console.next();

                                //check if input is product 1 in depot 1
                                if (depot1.getProduct1() != null) {
                                    if (tempProductInput.equalsIgnoreCase(depot1.getProduct1().getProductName())) {
                                        depot1.getProduct1().setProductQuantity(depot1.getProduct1().getProductQuantity() - 1);
                                        System.out.println(depot1.getProduct1().getProductName() + " now was a quantity of " + depot1.getProduct1().getProductQuantity() + ".");
                                        if (depot1.getProduct1().getProductQuantity() == 0) {
                                            System.out.println(depot1.getProduct1().getProductName() + " was removed.");
                                            depot1.setProduct1(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 2 in depot 1
                                if (depot1.getProduct2() != null) {
                                    if (tempProductInput.equalsIgnoreCase(depot1.getProduct2().getProductName())) {
                                        depot1.getProduct2().setProductQuantity(depot1.getProduct2().getProductQuantity() - 1);
                                        System.out.println(depot1.getProduct2().getProductName() + " now was a quantity of " + depot1.getProduct2().getProductQuantity() + ".");
                                        if (depot1.getProduct2().getProductQuantity() == 0) {
                                            System.out.println(depot1.getProduct2().getProductName() + " was removed.");
                                            depot1.setProduct2(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 3 in depot 1
                                if (depot1.getProduct3() != null) {
                                    if (tempProductInput.equalsIgnoreCase(depot1.getProduct3().getProductName())) {
                                        depot1.getProduct3().setProductQuantity(depot1.getProduct3().getProductQuantity() - 1);
                                        System.out.println(depot1.getProduct3().getProductName() + " now was a quantity of " + depot1.getProduct3().getProductQuantity() + ".");
                                        if (depot1.getProduct3().getProductQuantity() == 0) {
                                            System.out.println(depot1.getProduct3().getProductName() + " was removed.");
                                            depot1.setProduct1(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                                noProduct = 4;
                            }

                        } else {
                            if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())){
                                System.out.println(depot2.getDepotName()+" was chosen.");
                                System.out.println("PRODUCT NAME: ");
                                tempProductInput = console.next();

                                //check if input is product 1 in depot 2
                                if (depot2.getProduct1() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot2.getProduct1().getProductName())) {
                                        depot2.getProduct1().setProductQuantity(depot2.getProduct1().getProductQuantity() - 1);
                                        System.out.println(depot2.getProduct1().getProductName() + " now was a quantity of " + depot1.getProduct1().getProductQuantity() + ".");
                                        if (depot2.getProduct1().getProductQuantity() == 0) {
                                            System.out.println(depot2.getProduct1().getProductName() + " was removed.");
                                            depot2.setProduct1(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 2 in depot 2
                                if (depot2.getProduct2() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot2.getProduct2().getProductName())) {
                                        depot2.getProduct2().setProductQuantity(depot2.getProduct2().getProductQuantity() - 1);
                                        System.out.println(depot2.getProduct2().getProductName() + " now was a quantity of " + depot1.getProduct2().getProductQuantity() + ".");
                                        if (depot2.getProduct2().getProductQuantity() == 0) {
                                            System.out.println(depot2.getProduct2().getProductName() + " was removed.");
                                            depot2.setProduct2(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                                //check if input is product 3 in depot 2
                                if (depot2.getProduct3() != null){
                                    if (tempProductInput.equalsIgnoreCase(depot2.getProduct3().getProductName())) {
                                        depot2.getProduct3().setProductQuantity(depot2.getProduct3().getProductQuantity() - 1);
                                        System.out.println(depot2.getProduct3().getProductName() + " now was a quantity of " + depot1.getProduct3().getProductQuantity() + ".");
                                        if (depot2.getProduct3().getProductQuantity() == 0) {
                                            System.out.println(depot2.getProduct3().getProductName() + " was removed.");
                                            depot2.setProduct3(null);
                                        }
                                    } else {
                                        noProduct --;
                                    }
                                } else {
                                    noProduct ++;
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                                noProduct = 4;
                            }
                        }


                        if (noProduct == 3){
                            System.out.println("ERROR: No products currently exist!");
                        } else if (noProduct <= 1){
                            System.out.println("ERROR: This product does not exist!");
                        }
                    } else {
                        System.out.println("ERROR: No depots or products currently exist!");
                    }
                    break;

                case 5: //List Depots
                    if (depot1 != null || depot2 != null){
                        int depotOneTotal = 0;
                        int depotTwoTotal = 0;

                        /**
                         * the counters go up in each depot for each product that exists, this is then expressed as a string, if no depots exists it then states so
                         */
                        if (depot1 != null){
                            if (depot1.getProduct1() != null) {
                                depotOneTotal ++;
                            }
                            if (depot1.getProduct2() != null) {
                                depotOneTotal ++;
                            }
                            if (depot1.getProduct3() != null) {
                                depotOneTotal ++;
                            }
                            System.out.println(depot1.getDepotName()+" is a depot with "+depotOneTotal+" products");
                        }
                        if (depot2 != null){
                            if (depot2.getProduct1() != null){
                                depotTwoTotal ++;
                            }
                            if (depot2.getProduct2() != null){
                                depotTwoTotal ++;
                            }
                            if (depot2.getProduct3() != null){
                                depotTwoTotal ++;
                            }
                            System.out.println(depot2.getDepotName()+" is a depot with "+depotTwoTotal+" products");
                        }

                    } else {
                        System.out.println("ERROR: No depots currently exist!");
                    }
                    break;

                case 6: //List Products
                    if (depot1 != null || depot2 != null){
                        System.out.println("DEPOT NAME: ");
                        String tempDepotInput = console.next();
                        if (depot1!= null && depot2 != null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())){
                                System.out.println(depot1.getDepotName()+" was chosen.");
                                int noProductOutput = 0;
                                if (depot1.getProduct1() != null){
                                    System.out.println(depot1.getProduct1().getProductName()+" has price $"+depot1.getProduct1().getProductPrice()+", weight "+depot1.getProduct1().getProductWeight()+"KG and quantity "+depot1.getProduct1().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot1.getProduct2() != null){
                                    System.out.println(depot1.getProduct2().getProductName()+" has price $"+depot1.getProduct2().getProductPrice()+", weight "+depot1.getProduct2().getProductWeight()+"KG and quantity "+depot1.getProduct2().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot1.getProduct3() != null){
                                    System.out.println(depot1.getProduct3().getProductName()+" has price $"+depot1.getProduct3().getProductPrice()+", weight "+depot1.getProduct3().getProductWeight()+"KG and quantity "+depot1.getProduct3().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (noProductOutput == 3){
                                    System.out.println(depot1.getDepotName()+" currently exists but contains no products.");
                                }
                            } else if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())){
                                System.out.println(depot2.getDepotName()+" was chosen.");
                                int noProductOutput = 0;
                                if (depot2.getProduct1() != null){
                                    System.out.println(depot2.getProduct1().getProductName()+" has price $"+depot2.getProduct1().getProductPrice()+", weight "+depot2.getProduct1().getProductWeight()+"KG and quantity "+depot2.getProduct1().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot2.getProduct2() != null){
                                    System.out.println(depot2.getProduct2().getProductName()+" has price $"+depot2.getProduct2().getProductPrice()+", weight "+depot2.getProduct2().getProductWeight()+"KG and quantity "+depot2.getProduct2().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot2.getProduct3() != null){
                                    System.out.println(depot2.getProduct3().getProductName()+" has price $"+depot2.getProduct3().getProductPrice()+", weight "+depot2.getProduct3().getProductWeight()+"KG and quantity "+depot2.getProduct3().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (noProductOutput == 3){
                                    System.out.println(depot2.getDepotName()+" currently exists but contains no products.");
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else if (depot2 == null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())){
                                System.out.println(depot1.getDepotName()+" was chosen.");
                                int noProductOutput = 0;
                                if (depot1.getProduct1() != null){
                                    System.out.println(depot1.getProduct1().getProductName()+" has price $"+depot1.getProduct1().getProductPrice()+", weight "+depot1.getProduct1().getProductWeight()+"KG and quantity "+depot1.getProduct1().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot1.getProduct2() != null){
                                    System.out.println(depot1.getProduct2().getProductName()+" has price $"+depot1.getProduct2().getProductPrice()+", weight "+depot1.getProduct2().getProductWeight()+"KG and quantity "+depot1.getProduct2().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot1.getProduct3() != null){
                                    System.out.println(depot1.getProduct3().getProductName()+" has price $"+depot1.getProduct3().getProductPrice()+", weight "+depot1.getProduct3().getProductWeight()+"KG and quantity "+depot1.getProduct3().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (noProductOutput == 3){
                                    System.out.println(depot1.getDepotName()+" currently exists but contains no products.");
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else {
                            if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())){
                                System.out.println(depot2.getDepotName()+" was chosen.");
                                int noProductOutput = 0;
                                if (depot2.getProduct1() != null){
                                    System.out.println(depot2.getProduct1().getProductName()+" has price $"+depot2.getProduct1().getProductPrice()+", weight "+depot2.getProduct1().getProductWeight()+"KG and quantity "+depot2.getProduct1().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot2.getProduct2() != null){
                                    System.out.println(depot2.getProduct2().getProductName()+" has price $"+depot2.getProduct2().getProductPrice()+", weight "+depot2.getProduct2().getProductWeight()+"KG and quantity "+depot2.getProduct2().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (depot2.getProduct3() != null){
                                    System.out.println(depot2.getProduct3().getProductName()+" has price $"+depot2.getProduct3().getProductPrice()+", weight "+depot2.getProduct3().getProductWeight()+"KG and quantity "+depot2.getProduct3().getProductQuantity()+".");
                                } else {
                                    noProductOutput += 1;
                                }
                                if (noProductOutput == 3){
                                    System.out.println(depot2.getDepotName()+" currently exists but contains no products.");
                                }
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        }
                    } else {
                        System.out.println("ERROR: No depots currently exist!");
                    }
                    break;

                case 7: //Show Product Info
                    /**
                     * Checks if any depots exist, if they don't then no products can exist, prints an error. Otherwise, it continues to run.
                     * Secondly, a counter is declared, checks if a product exists, nested check if the input matches the product name
                     * Then, if it fails either, it adds to a counter respective to its fail case. Otherwise, if it tests true for a product, it displays the info and exits.
                     * If the counter reaches 6, or basically if it fails all if cases in some regard, it prints an error about either of the two reasons for failure.
                     */

                    if (depot1 != null || depot2 != null){
                        int noProductOutput = 0;
                        int incorrectInput = 0;
                        System.out.println("PRODUCT NAME: ");
                        String tempProductInput = console.next();

                        if (depot1 != null) {
                            if (depot1.getProduct1() != null) {
                                if (tempProductInput.equalsIgnoreCase(depot1.getProduct1().getProductName())) {
                                    System.out.println(depot1.getProduct1().getProductName()+" exists in "+depot1.getDepotName()+" with quantity "+depot1.getProduct1().getProductQuantity()+".");
                                } else {
                                    incorrectInput += 1;
                                }
                            } else {
                                noProductOutput += 1;
                                incorrectInput += 1;
                            }
                            if (depot1.getProduct2() != null) {
                                if (tempProductInput.equalsIgnoreCase(depot1.getProduct2().getProductName())) {
                                    System.out.println(depot1.getProduct2().getProductName()+" exists in "+depot1.getDepotName()+" with quantity "+depot1.getProduct2().getProductQuantity()+".");
                                } else {
                                    incorrectInput += 1;
                                }
                            } else {
                                noProductOutput += 1;
                                incorrectInput += 1;
                            }
                            if (depot1.getProduct3() != null) {
                                if (tempProductInput.equalsIgnoreCase(depot1.getProduct3().getProductName())) {
                                    System.out.println(depot1.getProduct3().getProductName()+" exists in "+depot1.getDepotName()+" with quantity "+depot1.getProduct3().getProductQuantity()+".");
                                } else {
                                    incorrectInput += 1;
                                }
                            } else {
                                noProductOutput += 1;
                                incorrectInput += 1;
                            }
                        } else {
                            noProductOutput += 3;
                            incorrectInput += 3;
                        }
                        if (depot2 != null){
                            if (depot2.getProduct1() != null) {
                                if (tempProductInput.equalsIgnoreCase(depot2.getProduct1().getProductName())) {
                                    System.out.println(depot2.getProduct1().getProductName()+" exists in "+depot2.getDepotName()+" with quantity "+depot2.getProduct1().getProductQuantity()+".");
                                } else {
                                    incorrectInput += 1;
                                }
                            } else {
                                noProductOutput += 1;
                                incorrectInput += 1;
                            }
                            if (depot2.getProduct2() != null) {
                                if (tempProductInput.equalsIgnoreCase(depot2.getProduct2().getProductName())) {
                                    System.out.println(depot2.getProduct2().getProductName()+" exists in "+depot2.getDepotName()+" with quantity "+depot2.getProduct2().getProductQuantity()+".");
                                } else {
                                    incorrectInput += 1;
                                }
                            } else {
                                noProductOutput += 1;
                                incorrectInput += 1;
                            }
                            if (depot2.getProduct3() != null) {
                                if (tempProductInput.equalsIgnoreCase(depot2.getProduct3().getProductName())) {
                                    System.out.println(depot2.getProduct3().getProductName()+" exists in "+depot2.getDepotName()+" with quantity "+depot2.getProduct3().getProductQuantity()+".");
                                } else {
                                    incorrectInput += 1;
                                }
                            } else {
                                noProductOutput += 1;
                                incorrectInput += 1;
                            }
                        } else {
                            noProductOutput += 3;
                            incorrectInput += 3;
                        }

                        if (noProductOutput == 6){
                            System.out.println("ERROR: No products currently exist!");
                        } else if (incorrectInput == 6){
                            System.out.println("ERROR: This product does not exist!");
                        }
                    } else {
                        System.out.println("ERROR: No depots and products currently exist!");
                    }
                    break;

                case 8: //Get Cumulative Value of Depot
                    if (depot1 != null || depot2 != null){
                        System.out.println("DEPOT NAME: ");
                        String tempDepotInput = console.next();

                        if (depot1 != null && depot2 != null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                double cumulativeValue = 0;

                                if (depot1.getProduct1() != null) {
                                    cumulativeValue += depot1.getProduct1().getProductPrice() * depot1.getProduct1().getProductQuantity();
                                }
                                if (depot1.getProduct2() != null) {
                                    cumulativeValue += depot1.getProduct2().getProductPrice() * depot1.getProduct2().getProductQuantity();
                                }
                                if (depot1.getProduct3() != null){
                                    cumulativeValue += depot1.getProduct3().getProductPrice() * depot1.getProduct3().getProductQuantity();
                                }

                                System.out.println("The cumulative value of "+depot1.getDepotName()+" is $"+cumulativeValue+".");
                            } else if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())){
                                double cumulativeValue = 0;

                                if (depot2.getProduct1() != null) {
                                    cumulativeValue += depot2.getProduct1().getProductPrice() * depot2.getProduct1().getProductQuantity();
                                }
                                if (depot2.getProduct2() != null) {
                                    cumulativeValue += depot2.getProduct2().getProductPrice() * depot2.getProduct2().getProductQuantity();
                                }
                                if (depot2.getProduct3() != null){
                                    cumulativeValue += depot2.getProduct3().getProductPrice() * depot2.getProduct3().getProductQuantity();
                                }

                                System.out.println("The cumulative value of "+depot2.getDepotName()+" is $"+cumulativeValue+".");
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else if (depot2 == null){
                            if (tempDepotInput.equalsIgnoreCase(depot1.getDepotName())) {
                                double cumulativeValue = 0;

                                if (depot1.getProduct1() != null) {
                                    cumulativeValue += depot1.getProduct1().getProductPrice() * depot1.getProduct1().getProductQuantity();
                                }
                                if (depot1.getProduct2() != null) {
                                    cumulativeValue += depot1.getProduct2().getProductPrice() * depot1.getProduct2().getProductQuantity();
                                }
                                if (depot1.getProduct3() != null) {
                                    cumulativeValue += depot1.getProduct3().getProductPrice() * depot1.getProduct3().getProductQuantity();
                                }

                                System.out.println("The cumulative value of " + depot1.getDepotName() + " is $" + cumulativeValue + ".");
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        } else {
                            if (tempDepotInput.equalsIgnoreCase(depot2.getDepotName())) {
                                double cumulativeValue = 0;

                                if (depot2.getProduct1() != null) {
                                    cumulativeValue += depot2.getProduct1().getProductPrice() * depot2.getProduct1().getProductQuantity();
                                }
                                if (depot2.getProduct2() != null) {
                                    cumulativeValue += depot2.getProduct2().getProductPrice() * depot2.getProduct2().getProductQuantity();
                                }
                                if (depot2.getProduct3() != null) {
                                    cumulativeValue += depot2.getProduct3().getProductPrice() * depot2.getProduct3().getProductQuantity();
                                }

                                System.out.println("The cumulative value of " + depot2.getDepotName() + " is $" + cumulativeValue + ".");
                            } else {
                                System.out.println("ERROR: This depot does not exist!");
                            }
                        }
                    } else {
                        System.out.println("ERROR: No depots currently exist!");
                    }
                    break;


            }
        } while (option!=0);
    }

    public static void main(String[] args)
    {
        Interface intFace = new Interface();
        intFace.run();
    }
}
