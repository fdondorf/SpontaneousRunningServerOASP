package io.oasp.spontaneous.general.service.impl.rest;

// BEGIN ARCHETYPE SKIP
// END ARCHETYPE SKIP
import io.oasp.module.rest.service.impl.json.ObjectMapperFactory;
import io.oasp.spontaneous.general.common.api.datatype.Money;
import io.oasp.spontaneous.offermanagement.logic.api.to.DrinkEto;
import io.oasp.spontaneous.offermanagement.logic.api.to.MealEto;
import io.oasp.spontaneous.offermanagement.logic.api.to.ProductEto;
import io.oasp.spontaneous.offermanagement.logic.api.to.SideDishEto;

import javax.inject.Named;

import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the restaurant application.
 *
 * @author agreul
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

  /**
   * The constructor.
   */
  public ApplicationObjectMapperFactory() {

    super();
    // register polymorphic base classes
    // BEGIN ARCHETYPE SKIP
    setBaseClasses(ProductEto.class);
    // END ARCHETYPE SKIP

    NamedType[] subtypes;
    // register mapping for polymorphic sub-classes
    // BEGIN ARCHETYPE SKIP
    subtypes =
        new NamedType[] { new NamedType(MealEto.class, "Meal"), new NamedType(DrinkEto.class, "Drink"),
        new NamedType(SideDishEto.class, "SideDish") };
    setSubtypes(subtypes);

    // register (de)serializers for custom datatypes
    SimpleModule module = getExtensionModule();
    module.addDeserializer(Money.class, new MoneyJsonDeserializer());
    module.addSerializer(Money.class, new MoneyJsonSerializer());
    // END ARCHETYPE SKIP
  }
}
