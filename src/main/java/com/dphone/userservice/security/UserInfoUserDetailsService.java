//package com.dphone.userservice.security; 
//
//import com.dphone.userservice.dao.UserDao;
//import com.dphone.userservice.entity.UserEntity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Optional;
//
//@Component
//public class UserInfoUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    	if(userDao.findByName(username).isPresent()) {
//    		UserEntity entity = userDao.findByName(username).get();
//    		entity.setStatus("active");
//    		userDao.save(entity); 
//    	}
//    	
//        Optional<UserEntity> userInfo = userDao.findByName(username);
//        
//        return userInfo.map(UserInfoUserDetails::new)
//                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
//
//    }
//}