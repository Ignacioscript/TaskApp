package edu.UdA.TaskApp.services;

import edu.UdA.TaskApp.models.Profile;
import edu.UdA.TaskApp.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements  ProfileService{

    ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getProfiles(){
        List<Profile> profiles = new ArrayList<>();
        profileRepository.findAll().forEach(profiles::add);
        return profiles;
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepository.findById(id).get();
    }

    @Override
    public Profile insert(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void updateProfile(Long id, Profile profile) {
        Profile profileFromDb = profileRepository.findById(id).get();
        System.out.println(profileFromDb.toString());
        profileFromDb.setUser(profile.getUser());
        profileFromDb.setPhone(profile.getPhone());
        profileRepository.save(profileFromDb);

    }

    @Override
    public void deleteProfile(Long profileId) {
        profileRepository.deleteById(profileId);

    }


}
