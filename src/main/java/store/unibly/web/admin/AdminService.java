package store.unibly.web.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.unibly.web.admin.dto.AdminProductDto;
import store.unibly.web.member.Member;
import store.unibly.web.member.MemberRole;
import store.unibly.config.error.DataNotFoundException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional(readOnly = true)
    public List<AdminProductDto> adminList(){
        return null;
    }

    public Member getMember(String loginId){
        Optional<Member> member = this.adminRepository.findById(loginId);
        if(member.isPresent()){
            Member data = member.get();
            if(data.getRole() == MemberRole.valueOf("ROLE_MANAGER")){
                return data;
            }
            else { throw new  DataNotFoundException("member is not manager"); }
        }
        else { throw new DataNotFoundException("member not found"); }
    }
}
