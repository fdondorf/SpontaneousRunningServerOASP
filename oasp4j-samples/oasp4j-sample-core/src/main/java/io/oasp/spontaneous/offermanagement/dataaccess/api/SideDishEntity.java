package io.oasp.spontaneous.offermanagement.dataaccess.api;

import io.oasp.spontaneous.offermanagement.common.api.SideDish;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.envers.Audited;

/**
 * The {@link io.oasp.spontaneous.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * {@link SideDish}.
 *
 * @author loverbec
 */
@Entity(name = "SideDish")
@DiscriminatorValue("SideDish")
@Audited
public class SideDishEntity extends ProductEntity implements SideDish {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public SideDishEntity() {

    super();
  }

}
