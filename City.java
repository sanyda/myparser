import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.concurrent.Executors;


@Getter
@Setter
@ToString
public class City {
    private String name;
    private String url;
    private String administrativeArea;
    private int numberOfCitizens;
    private String yearOfFound;
    private Coordinates coordinates; // Set this
    private double area;

    private static final int INFO_SIZE = 6;




    public static City parse(Element city) {
        Elements info = city.select("td");
        if (info.size() == INFO_SIZE) {
            Element anchor = info.get(1).select("a").get(0);
            City myCity = new City();
            myCity.setName(anchor.attr("title"));
            myCity.setUrl(String.format("https://uk.wikipedia.org%s", anchor.attr("href")));
            //TODO  set all other attributes
            return myCity;
        }
        return null;
    }

}
