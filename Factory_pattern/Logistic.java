package Factory_pattern;

import java.util.*;

public abstract class Logistic //declare  Logistic class as an abstract class
{
    abstract Transport createTransport(); //abstract method which will create a transport

    public void deliver() //method for deliver that transport
    {
        Transport transport = createTransport(); //declare an instance of Transport interface
        transport.deliver(); //then call deliver method of that instance
    }
}

class RoadLogistic extends Logistic //Road/Sea logistics will extend Logistic class
{

    @Override //overriding method because methods of abstract super class should be overridden, so that it will has own implementation
    public Transport createTransport()
    {
        return new Truck(); //return new Truck
    }
}

class SeaLogistic extends Logistic
{
    @Override
    public Transport createTransport()
    {
        return new Ship(); //returning new Ship
    }
}

interface Transport //interface for transport, it is like a button, and all products should implement all methods of this interface
{
    public void deliver();
}

class Ship implements Transport //class ship which implementing Transport interface
{
    @Override //override method cause of abstraction method of interface
    public void deliver()
    {
        System.out.println("deliver ship !");
        System.out.println("Ship: " + this); //returning this
    }

}

class Truck implements Transport //Truck code structure same as Ship
{
    @Override
    public void deliver()
    {
        System.out.println("deliver truck....");
        System.out.println("Truck: " + this);
    }
}

class Main
{
    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(System.in);

        Logistic especialLogistic; //instance of Logistic abstract class

        System.out.println("Write your logistic (sea or road)");

        String typeOfLogistic = in.next(); //our input like type of logistic (sea or road)

        if(typeOfLogistic.toLowerCase().equals("road"))
        {
            especialLogistic = new RoadLogistic(); //call RoadLogistic constructor
        }
        else if(typeOfLogistic.toLowerCase().equals("sea"))
        {
            especialLogistic = new SeaLogistic(); //call SeaLogistic constructor
        }
        else
        {
            throw new Exception("Program doesn't know about this type of logistic.");
        }
    }
}
