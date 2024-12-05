package ipss.cl.apis70.models;

import java.util.List;

import lombok.Data;

@Data
public class Fabricante {

  private String name;
  private List<Consola> consola;
}
