package se.fk.github.rimfrost.erbjudande.presentation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import java.util.UUID;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.ErbjudandeControllerApi;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Erbjudande;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetErbjudandeResponse;

@ApplicationScoped
@Path("/erbjudande/{erbjudandeId}")
public class ErbjudandeController implements ErbjudandeControllerApi
{
   @Override
   public GetErbjudandeResponse getErbjudande(UUID erbjudandeId)
   {
      Erbjudande erbjudande = new Erbjudande();
      erbjudande.setId(erbjudandeId);
      erbjudande.setNamn("Ansöka om tillfällig vård av husdjur");
      erbjudande.setVersion("1.0");
      erbjudande.setProduktId(UUID.fromString("f2ecbb24-b492-4eab-84b8-e11f751a854c"));

      GetErbjudandeResponse response = new GetErbjudandeResponse();
      response.setErbjudande(erbjudande);

      return response;
   }
}
