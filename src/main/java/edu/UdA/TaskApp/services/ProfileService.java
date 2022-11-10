package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.Profile;

import java.util.List;

public interface ProfileService {

    List<Profile> getProfiles();

    Profile getProfileById(Long id);

    Profile insert(Profile profile);

    Profile updateProfile(Long id, Profile profile);

    boolean deleteProfile(Long profileId);
}
