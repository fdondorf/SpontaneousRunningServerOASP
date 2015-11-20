package io.oasp.spontaneous.offermanagement.dataaccess.api.dao;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;
import io.oasp.spontaneous.general.dataaccess.api.dao.ApplicationRevisionedDao;
import io.oasp.spontaneous.offermanagement.dataaccess.api.ProductEntity;
import io.oasp.spontaneous.offermanagement.logic.api.to.ProductFilter;
import io.oasp.spontaneous.offermanagement.logic.api.to.ProductSearchCriteriaTo;
import io.oasp.spontaneous.offermanagement.logic.api.to.ProductSortBy;

import java.util.List;

/**
 * {@link ApplicationRevisionedDao Data Access Object} for {@link ProductEntity} entity.
 *
 * @author loverbec
 */
public interface ProductDao extends ApplicationRevisionedDao<ProductEntity>, MasterDataDao<ProductEntity> {

  /**
   * @param productFilter is the {@link ProductFilter}.
   * @param sortBy is the {@link ProductSortBy} criteria.
   * @return the {@link List} of filtered and sorted {@link ProductEntity products}.
   */
  @Deprecated
  List<ProductEntity> findProductsFiltered(ProductFilter productFilter, ProductSortBy sortBy);

  /**
   * Finds the {@link ProductEntity} objects matching the given {@link ProductSearchCriteriaTo}.
   *
   * @param criteria is the {@link ProductSearchCriteriaTo}.
   * @return the {@link List} with the matching {@link ProductEntity} objects.
   */
  PaginatedListTo<ProductEntity> findProducts(ProductSearchCriteriaTo criteria);

}
