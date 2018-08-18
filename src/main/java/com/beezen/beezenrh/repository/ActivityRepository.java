package com.beezen.beezenrh.repository;

import com.beezen.beezenrh.domain.Activity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Activity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query("select jhi_activity from Activity jhi_activity where jhi_activity.user.login = ?#{principal.username}")
    List<Activity> findByUserIsCurrentUser();

}
