package com.beezen.beezenrh.service;

import com.beezen.beezenrh.domain.Activity;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Activity.
 */
public interface ActivityService {

    /**
     * Save a activity.
     *
     * @param activity the entity to save
     * @return the persisted entity
     */
    Activity save(Activity activity);

    /**
     * Get all the activities.
     *
     * @return the list of entities
     */
    List<Activity> findAll();


    /**
     * Get the "id" activity.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<Activity> findOne(Long id);

    /**
     * Delete the "id" activity.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
