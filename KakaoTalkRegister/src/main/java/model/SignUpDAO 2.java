//package model;
//
//import java.sql.SQLException;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//
//import org.modelmapper.ModelMapper;
//
//import model.dto.MemberDTO;
//import model.entity.Member;
//import model.util.PublicCommon;
//
//public class SignUpDAO {
//
//	private static SignUpDAO instance = new SignUpDAO();
//	
//	private SignUpDAO() {}
//	
//	public static SignUpDAO getInstance() {
//		return instance;
//	}
//	
//	
////	public boolean addMember(String id, String pw, String member_name) throws Exception {
////		EntityManager em = PublicCommon.getEntityManager();
////		EntityTransaction tx = em.getTransaction();
////
////		Member memberEntity = null;
////
////		try {
////			tx.begin();
////
////			ModelMapper modelMapper = new ModelMapper();
////			memberEntity = modelMapper.map(new Member(id, pw, member_name), Member.class);
////
////			em.persist(memberEntity);
////			tx.commit();
////
////			return true;
////		} catch (Exception e) {
////			tx.rollback();
////			throw e;
////		} finally {
////			em.close();
////			em = null;
////		}
////	}
//	
//	
////	public MemberDTO getMember(String memberId) throws Exception {
////		EntityManager em = PublicCommon.getEntityManager();
////		EntityTransaction tx = em.getTransaction();
////
////		Member member = null;
////		MemberDTO memberDTO = null;
////
////		try {
////			
////			member = em.createNamedQuery("Member.findOne", Member.class)
////							.setParameter("id", memberId)
////							.getSingleResult();
////			
////			ModelMapper modelMapper = new ModelMapper();
////			memberDTO = modelMapper.map(member, MemberDTO.class);
////			
////			return memberDTO;
////
////		} catch (Exception s) {
////			tx.rollback();
////			s.printStackTrace();
////			throw s;
////		} finally {
////			em.close();
////			em = null;
////		}
////	}
//	
////	public List<MemberDTO> getAllMembers() throws SQLException {
////		EntityManager em = PublicCommon.getEntityManager();
////		EntityTransaction tx = em.getTransaction();
////
////		List<Member> list = null;
////		List<MemberDTO> listDTO = null;
////
////		try {
////			tx.begin();
////
////			list = em.createNamedQuery("Member.findAll", Member.class).getResultList();
////
////			ModelMapper modelMapper = new ModelMapper();
////			listDTO = list.stream().map(d -> modelMapper.map(d, MemberDTO.class)).collect(Collectors.toList());
////
////		} catch (Exception s) {
////			tx.rollback();
////			s.printStackTrace();
////			throw s;
////		} finally {
////			em.close();
////			em = null;
////		}
////		return listDTO;
////	}
//	
//}