package api.com.medhead.service;

import api.com.medhead.model.ERole;
import api.com.medhead.model.Role;
import api.com.medhead.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @InjectMocks
    private RoleService roleService;

    @Mock
    private RoleRepository roleRepository;

    Role r = new Role(ERole.ROLE_ADMIN);

    @Test
    void findByName() {
        when(roleRepository.findByName(any())).thenReturn(Optional.ofNullable(r));
        Optional<Role> role = roleService.findByName(ERole.ROLE_ADMIN);
        assertEquals(r.getName(), role.get().getName());
    }
}
