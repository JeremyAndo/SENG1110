//c3315176 - Jeremy Anderson

public class Depot
{
    private String name;
    private Product product[] = new Product[5];

    /**
     * Creates 3 initial products within a depot
     */
    public Depot()
    {
        name = null;
        product[0] = null;
        product[1] = null;
        product[2] = null;
        product[3] = null;
        product[4] = null;

    }
    //add other methods
    public Depot(String newDepotName)
    {
        name = newDepotName;
    }

    public void setDepotName(String newDepotName)
    {
        name = newDepotName;
    }

    public String getDepotName()
    {
        return name;
    }

    public Product getProduct0()
    {
        return product[0];
    }

    public Product getProduct1()
    {
        return product[1];
    }

    public Product getProduct2()
    {
        return product[2];
    }

    public Product getProduct3()
    {
        return product[3];
    }

    public Product getProduct4()
    {
        return product[4];
    }

    public void setProduct0(Product product)
    {
        this.product[0] = product;
    }

    public void setProduct1(Product product)
    {
        this.product[1] = product;
    }

    public void setProduct2(Product product)
    {
        this.product[2] = product;
    }

    public void setProduct3(Product product)
    {
        this.product[3] = product;
    }

    public void setProduct4(Product product)
    {
        this.product[4] = product;
    }
}
