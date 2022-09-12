import com.pi4j.catalog.Application;
import com.pi4j.catalog.Launcher;

import java.util.ArrayList;

public class Task {
  //put your task here
  public static void main(String[] args) {
    var apps = new ArrayList<Application>();
    var launcher = new Launcher(apps);

    launcher.execute(null);
  }
}