package io.oasp.spontaneous.staffmanagement.services;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import io.oasp.spontaneous.general.common.AbstractRestServiceTest;
import io.oasp.spontaneous.staffmanagement.logic.api.to.StaffMemberEto;
import io.oasp.spontaneous.test.config.RestUrls;
import io.oasp.spontaneous.test.config.TestData.Additional;
import io.oasp.spontaneous.test.config.TestData.DB;
import io.oasp.spontaneous.test.general.webclient.ResponseData;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

/**
 * Test staff management rest service
 *
 * @author arklos
 */
public class StaffManagementRestServiceTest extends AbstractRestServiceTest {

  /**
   * Tests get staff member
   */
  @Test
  public void getStaffmemberTest() {

    ResponseData<StaffMemberEto> member =
        this.waiter.get(
            RestUrls.StaffManagement.getDeleteStaffMemberUrl(DB.STAFF_MEMEBR_1.getLastName().toLowerCase()),
            StaffMemberEto.class);
    assertThat(member.getResponse().getStatus(), is(200));
    assertThat(member.getResponseObject().getId(), is(DB.STAFF_MEMEBR_1.getId()));
  }

  /**
   * Test get all staff members
   */
  @Test
  public void getAllStaffmembersTest() {

    List<ResponseData<StaffMemberEto>> members =
        this.waiter.getAll(RestUrls.StaffManagement.getGetAllStaffMembersUrl(), StaffMemberEto.class);
    assertThat(4, is(members.size()));
  }

  /**
   * Tests update staffMember
   */
  @Test
  @Ignore
  public void updateStaffMemberTest() {

    this.chief.put(RestUrls.StaffManagement.getUpdateStaffMember(DB.STAFF_MEMEBR_1.getLastName().toLowerCase()),
        Additional.CHANGED_STAFF_MEMEBR_1);
    ResponseData<StaffMemberEto> member =
        this.chief.get(RestUrls.StaffManagement.getGetStaffMember(DB.STAFF_MEMEBR_1.getLastName().toLowerCase()),
            StaffMemberEto.class);
    assertThat(member.getResponse().getStatus(), is(200));
    assertThat(member.getResponseObject().getFirstName(), is(Additional.CHANGED_STAFF_MEMEBR_1.getFirstName()));
  }

  /**
   * Test delete member
   */
  @Test
  @Ignore
  public void delteStaffMemberTest() {

    this.chief.delete(RestUrls.StaffManagement.getDeleteStaffMemberUrl(DB.STAFF_MEMEBR_1.getLastName().toLowerCase()));
    List<ResponseData<StaffMemberEto>> members =
        this.waiter.getAll(RestUrls.StaffManagement.getGetAllStaffMembersUrl(), StaffMemberEto.class);
    assertThat(members.size(), is(DB.ALL_STAFF_MEMBER.size() - 1));
  }
}
