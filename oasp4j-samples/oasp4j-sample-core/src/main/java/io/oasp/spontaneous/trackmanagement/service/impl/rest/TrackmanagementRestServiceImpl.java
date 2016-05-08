package io.oasp.spontaneous.trackmanagement.service.impl.rest;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.common.api.to.PaginationTo;
import io.oasp.spontaneous.trackmanagement.logic.api.Trackmanagement;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackEto;
import io.oasp.spontaneous.trackmanagement.logic.api.to.TrackSearchCriteriaTo;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcFindTrack;
import io.oasp.spontaneous.trackmanagement.logic.api.usecase.UcManageTrack;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.transaction.annotation.Transactional;

/**
 * The service class for REST calls in order to execute the methods in {@link Trackmanagement}.
 */
@Path("/trackmanagement/v1")
@Named("TrackmanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class TrackmanagementRestServiceImpl {

  private Trackmanagement trackManagement;

  /**
   * This method sets the field <tt>trackManagement</tt>.
   *
   * @param trackManagement the new value of the field trackManagement
   */
  @Inject
  public void setTrackManagement(Trackmanagement trackManagement) {

    this.trackManagement = trackManagement;
  }

  /**
   * Delegates to {@link UcFindTrack#findTrack}.
   *
   * @param id the ID of the {@link TrackEto}
   * @return the {@link TrackEto}
   */
  @GET
  @Path("/track/{id}/")
  public TrackEto getTrack(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("track not found");
    }
    return this.trackManagement.findTrack(idAsLong);
  }

  /**
   * Delegates to {@link UcManageTrack#createTrack}.
   *
   * @param track the {@link TrackEto} to be created
   * @return the recently created {@link TrackEto}
   */
  @POST
  @Path("/track/")
  public TrackEto saveTrack(TrackEto track) {

    TrackEto trackEto = this.trackManagement.saveTrack(track);
    return trackEto;
  }

  /**
   * Delegates to {@link UcManageTrack#deleteTrack}.
   *
   * @param id ID of the {@link TrackEto} to be deleted
   */
  @DELETE
  @Path("/track/{id}/")
  public void deleteTrack(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("track not found");
    }
    this.trackManagement.deleteTrack(idAsLong);
  }

  /**
   * Delegates to {@link UcFindTrack#findTrackEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding tracks.
   * @return the {@link PaginatedListTo list} of matching {@link TrackEto}s.
   */
  @Path("/track/search")
  @POST
  public PaginatedListTo<TrackEto> findTracksByPost(TrackSearchCriteriaTo searchCriteriaTo) {

    return this.trackManagement.findTrackEtos(searchCriteriaTo);
  }

  /**
   * Delegates to {@link UcFindTrack#findTrackEtos}.
   *
   * @return the {@link PaginatedListTo list} of matching {@link TrackEto}s.
   */
  @Path("/tracks")
  @GET
  public PaginatedListTo<TrackEto> getAllTracks() {

    TrackSearchCriteriaTo searchCriteriaTo = new TrackSearchCriteriaTo();
    PaginationTo paginationTo = new PaginationTo();
    paginationTo.setPage(1);
    paginationTo.setSize(10);
    paginationTo.setTotal(true);
    searchCriteriaTo.setPagination(paginationTo);

    return this.trackManagement.findTrackEtos(searchCriteriaTo);
  }

}
