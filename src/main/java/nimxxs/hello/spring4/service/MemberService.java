package nimxxs.hello.spring4.service;

import nimxxs.hello.spring4.model.Member;

public interface MemberService {
    boolean saveMember(Member m);
    boolean loginMember(Member m);
}
