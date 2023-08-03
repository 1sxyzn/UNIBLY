package store.unibly.web.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.unibly.web.admin.dto.AdminProductDto;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional(readOnly = true)
    public List<AdminProductDto> adminList(){
        return null;
    }
}
