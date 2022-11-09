package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getProfiles();

    Profile getProfileById(Long id);

    Profile insert(Profile profile);

    void  updateProfile(Long id, Profile profile);

    void deleteProfile(Long profileId);
}
