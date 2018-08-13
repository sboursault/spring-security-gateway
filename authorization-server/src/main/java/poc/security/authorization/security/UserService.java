package poc.security.authorization.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import poc.security.authorization.repository.UserRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    @Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findOneByUsername(username)
				.getOrElseThrow(() -> new UsernameNotFoundException("username was not found"));
	}
}
