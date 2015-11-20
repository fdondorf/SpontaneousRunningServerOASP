package io.oasp.spontaneous.trackmanagement.dataaccess.impl.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.spontaneous.general.dataaccess.base.dao.ApplicationDaoImpl;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.TrackEntity;
import io.oasp.spontaneous.trackmanagement.dataaccess.api.dao.TrackDao;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

/**
 * This is the implementation of {@link TrackDao}.
 */
@Named
public class TrackDaoImpl extends ApplicationDaoImpl<TrackEntity> implements TrackDao {

  /**
   * The constructor.
   */
  public TrackDaoImpl() {

    super();
  }

  @Override
  public Class<TrackEntity> getEntityClass() {

    return TrackEntity.class;
  }

  @Override
  public PaginatedListTo<TrackEntity> findTracks(TrackSearchCriteriaTo criteria) {

    TrackEntity track = Alias.alias(TrackEntity.class);
    EntityPathBase<TrackEntity> alias = Alias.$(track);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(track.getName()).eq(name));
    }

    Long totalDistance = criteria.getTotalDistance();
    if (totalDistance != null) {
      query.where(Alias.$(track.getTotalDistance()).eq(totalDistance));
    }

    Long totalDuration = criteria.getTotalDuration();
    if (totalDuration != null) {
      query.where(Alias.$(track.getTotalDuration()).eq(totalDuration));
    }

    return findPaginated(criteria, query, alias);
  }

}
