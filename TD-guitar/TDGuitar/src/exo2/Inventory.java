package exo2;

import java.util.LinkedList;
import java.util.List;

public class Inventory {
  private List<Guitar> guitars;

  public Inventory() {
    guitars = new LinkedList<>();
  }

  public void addGuitar(String serialNumber, double price,
                        Builder builder, String model,
                        Type type, Wood backWood, Wood topWood) {
    guitars.add(new Guitar(serialNumber, price, builder, model, type, backWood, topWood));
  }
  
  public Guitar getGuitar(String serialNumber) {
    for (Guitar guitar : guitars) {
      if (guitar.getSerialNumber().equals(serialNumber))
        return guitar;
    }
    return null;
  }
  
  public List<Guitar> search(Guitar searchGuitar) {
    List<Guitar> result = new LinkedList<>();
    for (Guitar guitar : guitars) {
      // Ignore serial number since that's unique
      // Ignore price since that's unique
      Builder builder = searchGuitar.getBuilder();
      if ((builder != null) && (!builder.equals("")) &&
              (!builder.equals(guitar.getBuilder())))
        continue;

      String model = searchGuitar.getModel();
      if ((model != null) && (!model.equals("")) && (!model.equals(guitar.getModel())))
        continue;

      Type type = searchGuitar.getType();
      if((type != null) && (!type.equals("")) && (!type.equals(guitar.getType())))
        continue;

      Wood backWood = searchGuitar.getBackWood();
      if((backWood != null) && (!backWood.equals("")) && (!backWood.equals(guitar.getBackWood())))
        continue;

      Wood topWood = searchGuitar.getTopWood();
      if((topWood != null) && (!topWood.equals("")) && (!topWood.equals(guitar.getTopWood())))
        continue;

      result.add(guitar);
    }
    return result;
  }
  
}
