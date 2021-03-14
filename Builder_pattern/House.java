package Builder_pattern;

class House
{
    private String foundation;
    private String frame;
    private String roof;
    private String doors;
    private String plumbing;

    //declare setters for all fields of House

    public void setFoundation(String foundation)
    {
        this.foundation = foundation;
    }

    public void setFrame(String frame)
    {
        this.doors = frame;
    }

    public void setRoof(String roof)
    {
        this.roof = roof;
    }

    public void setDoors(String doors)
    {
        this.doors = doors;
    }

    public void setPlumbing(String plumbing)
    {
        this.plumbing = plumbing;
    }
}


interface HouseBuilder //declare interface Builder for our House
{

    public void buildFoundation(); //building foundation

    public void buildFrame(); //building frame

    public void buildRoof(); //building roof

    public void buildDoors(); //building doors

    public void buildPlumbing(); //building plumbing

    public House getResult(); //getting a result of house construction
}

class TreeHouseBuilder implements HouseBuilder //TreeHouseBuilder, so he is worker for building homes of tree
{
    private House house; //aggregation relationship

    public TreeHouseBuilder()
    {
        this.house = new House();
    } //constructor of class which will calling a constructor of House

    @Override
    public void buildFoundation()
    {
        house.setFoundation("build Tree foundation");
    } //build tree foundation

    @Override
    public void buildFrame()
    {
        house.setFrame("build Tree frame");
    } //build tree frame

    @Override
    public void buildRoof()
    {
        house.setRoof("build Tree roof");
    } //build tree roof

    @Override
    public void buildDoors()
    {
        house.setDoors("build Tree doors");
    } //build tree doors

    @Override
    public void buildPlumbing() {
        house.setPlumbing("build Tree plumbing");
    } //build tree plumbing

    public House getResult()
    {
        return this.house;
    } //get result like return instance of House
}

class BungalowHouseBuilder implements HouseBuilder
{
    private House house;

    public BungalowHouseBuilder()
    {
        this.house = new House(); //creating an object of instance
    }

    @Override
    public void buildFoundation()
    {
        house.setFoundation("build Bungalow foundation");
    } //build bungalow foundation

    @Override
    public void buildFrame()
    {
        house.setFrame("build Bungalow frame");
    } //build bungalow frame

    @Override
    public void buildRoof()
    {
        house.setRoof("build Bungalow roof");
    } //build bungalow roof

    @Override
    public void buildDoors()
    {
        house.setDoors("build Bungalow doors");
    } //build bungalow doors

    @Override
    public void buildPlumbing() {
        house.setPlumbing("build Bungalow plumbing");
    } //build bungalow plumbing

    public House getResult()
    {
        return this.house;
    }

}

class BuildingEngineer
{

    private HouseBuilder builderHouse; //Building Engineer whave instance of HouseBuilder

    public BuildingEngineer(HouseBuilder builderHouse)  //constructor which will have parameter as housebuilder
    {
        this.builderHouse = builderHouse;
    }

    public void constructHouse() //method which will construct our chosen type of house
    {
        this.builderHouse.buildFoundation();
        this.builderHouse.buildFrame();
        this.builderHouse.buildRoof();
        this.builderHouse.buildDoors();
        this.builderHouse.buildPlumbing();
    }

    public House getHouse() //get house will just provide as that house has built
    {
        return this.builderHouse.getResult();
    }
}

class Builder
{
    public static void main(String[] args)
    {
        HouseBuilder houseBuilder = new TreeHouseBuilder(); //HouseBuilder class instance call TreeHouseBuilder constructor

        BuildingEngineer engineer = new BuildingEngineer(houseBuilder); //and we transfer it to BuildingEngineer constructor as parameter

        engineer.constructHouse(); //calling constructHouse() for construct our house
        House house = engineer.getHouse(); //get our house
        System.out.println(house); //in the end we will get the result
    }
}