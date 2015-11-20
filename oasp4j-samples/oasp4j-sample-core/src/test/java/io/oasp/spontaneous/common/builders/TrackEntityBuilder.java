package io.oasp.spontaneous.common.builders;

import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;

public class TrackEntityBuilder {

  private List<P<TrackEntity>> parameterToBeApplied;

  public TrackEntityBuilder() {

    parameterToBeApplied = new LinkedList<P<TrackEntity>>();
    fillMandatoryFields();
    fillMandatoryFields_custom();
  }

  public TrackEntityBuilder name(final String name) {

    parameterToBeApplied.add(new P<TrackEntity>() {
      @Override
      public void apply(TrackEntity target) {

        target.setName(name);
      }
    });
    return this;
  }

  public TrackEntityBuilder totalDistance(final Long totalDistance) {

    parameterToBeApplied.add(new P<TrackEntity>() {
      @Override
      public void apply(TrackEntity target) {

        target.setTotalDistance(totalDistance);
      }
    });
    return this;
  }

  public TrackEntityBuilder totalDuration(final Long totalDuration) {

    parameterToBeApplied.add(new P<TrackEntity>() {
      @Override
      public void apply(TrackEntity target) {

        target.setTotalDuration(totalDuration);
      }
    });
    return this;
  }

  public TrackEntityBuilder revision(final Number revision) {

    parameterToBeApplied.add(new P<TrackEntity>() {
      @Override
      public void apply(TrackEntity target) {

        target.setRevision(revision);
      }
    });
    return this;
  }

  public TrackEntity createNew() {

    TrackEntity trackentity = new TrackEntity();
    for (P<TrackEntity> parameter : parameterToBeApplied) {
      parameter.apply(trackentity);
    }
    return trackentity;
  }

  public TrackEntity persist(EntityManager em) {

    TrackEntity trackentity = createNew();
    em.persist(trackentity);
    return trackentity;
  }

  public List<TrackEntity> persistAndDuplicate(EntityManager em, int quantity) {

    List<TrackEntity> trackentityList = new LinkedList<TrackEntity>();
    for (int i = 0; i < quantity; i++) {
      TrackEntity trackentity = createNew();
      // TODO alter at least values with unique key constraints to prevent from exceptions while persisting
      em.persist(trackentity);
      trackentityList.add(trackentity);
    }

    return trackentityList;
  }

  /**
   * Might be enrichted to users needs (will not be overwritten)
   */
  private void fillMandatoryFields_custom() {

  }

  /**
   * Fills all mandatory fields by default. (will be overwritten on re-generation)
   */
  private void fillMandatoryFields() {

  }

}
