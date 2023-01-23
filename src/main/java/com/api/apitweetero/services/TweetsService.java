package com.api.apitweetero.services;

import com.api.apitweetero.dtos.TweetsDTO;
import com.api.apitweetero.dtos.TweetsWithAvatarDTO;
import com.api.apitweetero.errors.NotFoundException;
import com.api.apitweetero.models.TweetsModel;
import com.api.apitweetero.models.UsersModel;
import com.api.apitweetero.repositories.TweetsRepository;
import com.api.apitweetero.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetsService {
    private final TweetsRepository tweetsRepo;
    private final UsersRepository usersRepo;
    public  TweetsService(TweetsRepository tweetsRepo, UsersRepository usersRepo){
        this.tweetsRepo = tweetsRepo;
        this.usersRepo = usersRepo;
    }

    public void save(TweetsDTO tweets) throws NotFoundException {
        UsersModel user = this.usersRepo.findByUsername(tweets.username());
        if(user == null) throw new NotFoundException("There is not an user with this username");
        this.tweetsRepo.save(new TweetsModel(tweets));
    }

    public List<TweetsWithAvatarDTO> getTweetsByUsernameWithAvatar(String username) throws  NotFoundException {
        UsersModel user = this.usersRepo.findByUsername(username);
        if(user == null) throw new NotFoundException("There is not an user with this username");
        return this.tweetsRepo.findByUsername(username).stream().map(tweet -> new TweetsWithAvatarDTO(tweet.getUsername(),user.getAvatar(),tweet.getTweet())).toList();
    }
}
