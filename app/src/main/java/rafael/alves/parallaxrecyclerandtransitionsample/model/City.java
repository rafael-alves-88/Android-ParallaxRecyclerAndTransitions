package rafael.alves.parallaxrecyclerandtransitionsample.model;

import java.util.ArrayList;
import java.util.List;

public class City {

    public String Name;
    public String Image;

    public static List<City> getCities() {
        List<City> cityList = new ArrayList<>();

        City auckland = new City();
        auckland.Name = "Auckland";
        auckland.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b10-auckland_2311071k.jpg";
        cityList.add(auckland);

        City perth = new City();
        perth.Name = "Perth";
        perth.Image = "http://i.telegraph.co.uk/multimedia/archive/02353/perth_2353704k.jpg";
        cityList.add(perth);

        City helsinki = new City();
        helsinki.Name = "Helsinki";
        helsinki.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b08-helsinki_2311099k.jpg";
        cityList.add(helsinki);

        City sydney = new City();
        sydney.Name = "Sydney";
        sydney.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b07-sydney_2311085k.jpg";
        cityList.add(sydney);

        City adelaide = new City();
        adelaide.Name = "Adelaide";
        adelaide.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b06-adelaide_2311089k.jpg";
        cityList.add(adelaide);

        City calgary = new City();
        calgary.Name = "Calgary";
        calgary.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b05-calgary_2311080k.jpg";
        cityList.add(calgary);

        City toronto = new City();
        toronto.Name = "Toronto";
        toronto.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b04-toronto_2311087k.jpg";
        cityList.add(toronto);

        City vancouver = new City();
        vancouver.Name = "Vancouver";
        vancouver.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b03-vancouver_2311063k.jpg";
        cityList.add(vancouver);

        City vienna = new City();
        vienna.Name = "Vienna";
        vienna.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b02-vienna_2311068k.jpg";
        cityList.add(vienna);

        City melbourne = new City();
        melbourne.Name = "Melbourne";
        melbourne.Image = "http://i.telegraph.co.uk/multimedia/archive/02311/b01-melbourne_2311083k.jpg";
        cityList.add(melbourne);

        return cityList;
    }
}
