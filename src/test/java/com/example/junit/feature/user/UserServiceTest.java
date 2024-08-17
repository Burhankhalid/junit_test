package com.example.junit.feature.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.example.junit.domain.User;
import com.example.junit.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setName("John Doe");

        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.save(user);

        assertThat(createdUser).isNotNull();
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("John Doe");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.findById(1L);

        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getEmail()).isEqualTo("test@example.com");
        verify(userRepository, times(1)).findById(1L);
    }


    @Test
    void testDeleteUserById() {
        Long userId = 1L;

        doNothing().when(userRepository).deleteById(userId);

        userService.deleteById(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}
