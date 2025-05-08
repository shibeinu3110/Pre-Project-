package com.example.l3.consts;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StoredProcedureConst {
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Mapper {
        public static final String USER_DTO_MAPPER = "UserDtoMapper";
        public static final String ROLE_DTO_MAPPER = "RoleDtoMapper";
        public static final String EMPLOYEE_DTO_MAPPER = "EmployeeDtoMapper";
        public static final String CERTIFICATE_DTO_MAPPER = "CertificateDtoMapper";
        public static final String RELATIONSHIP_DTO_MAPPER = "RelationshipDtoMapper";
        public static final String SALARY_INCREMENT_DTO_MAPPER = "SalaryIncrementDtoMapper";
        public static final String PROMOTION_DTO_MAPPER = "PromotionDtoMapper";
        public static final String PROPOSAL_ADVICE_DTO_MAPPER = "ProposalAdviceDtoMapper";
        public static final String REGISTRATION_DTO_MAPPER = "RegistrationDtoMapper";
        public static final String PROFILE_END_DTO_MAPPER = "ProfileEndDtoMapper";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Parameter {
        public static final String USER_ID = "user_id";
        public static final String USERNAME = "username";
        public static final String ROLE_ID = "role_id";
        public static final String USER_JSON = "user_json";
        public static final String EMAIL = "email";
        public static final String POSTCODE = "postcode";
        public static final String PHONE = "phone";
        public static final String EMPLOYEE_JSON = "employee_json";
        public static final String EMPLOYEE_ID = "employee_id";
        public static final String EMPLOYEE_CODE = "employee_code";
        public static final String CERTIFICATE_JSON = "certificate_json";
        public static final String CERTIFICATE_ID = "certificate_id";

        public static final String RELATIONSHIP_JSON = "relationship_json";
        public static final String RELATIONSHIP_ID = "relationship_id";

        public static final String SALARY_INCREMENT_JSON = "salary_increment_json";
        public static final String SALARY_INCREMENT_ID = "salary_increment_id";

        public static final String PROMOTION_JSON = "promotion_json";
        public static final String PROMOTION_ID = "promotion_id";

        public static final String PROPOSAL_ADVICE_JSON = "proposal_advice_json";
        public static final String PROPOSAL_ADVICE_ID = "proposal_advice_id";

        public static final String REGISTRATION_JSON = "registration_json";
        public static final String REGISTRATION_ID = "registration_id";

        public static final String PROFILE_END_JSON = "profile_end_json";
        public static final String PROFILE_END_ID = "profile_end_id";
        public static final String STORAGE_NUMBER = "storage_number";

    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class User {
        public static final String GET_USER_BY_USERNAME = "get_user_by_username";
        public static final String CREATE_USER = "create_user";
        public static final String EXIST_USER_BY_PHONE = "exist_user_by_phone";
        public static final String EXIST_USER_BY_USERNAME = "exist_user_by_username";
        public static final String EXIST_USER_BY_EMAIL = "exist_user_by_email";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Role {
        public static final String GET_ROLE_BY_ID = "get_role_by_id";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Employee {
        public static final String CREATE_EMPLOYEE = "create_employee";
        public static final String GET_EMPLOYEE_BY_ID = "get_employee_by_id";
        public static final String EXIST_EMPLOYEE_BY_EMAIL = "exist_employee_by_email";
        public static final String EXIST_EMPLOYEE_BY_POSTCODE = "exist_employee_by_postcode";
        public static final String EXIST_EMPLOYEE_BY_PHONE = "exist_employee_by_phone";
        public static final String EXIST_EMPLOYEE_BY_EMPLOYEE_CODE = "exist_employee_by_employee_code";
        public static final String UPDATE_EMPLOYEE = "update_employee";


        public static final String DELETE_EMPLOYEE_BY_ID = "delete_employee_by_id";
        public static final String EXIST_EMPLOYEE_BY_ID = "exist_employee_by_id";
        public static final String GET_ALL_EMPLOYEE = "get_all_employee";
    }


    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Certificate {
        public static final String CREATE_CERTIFICATE = "create_certificate";
        public static final String GET_ALL_CERTIFICATE = "get_all_certificate";
        public static final String GET_CERTIFICATE_BY_ID = "get_certificate_by_id";
        public static final String EXIST_CERTIFICATE_BY_ID = "exist_certificate_by_id";
        public static final String DELETE_CERTIFICATE_BY_ID = "delete_certificate_by_id";
        public static final String GET_CERTIFICATE_BY_EMPLOYEE_ID = "get_certificate_by_employee_id";
        public static final String UPDATE_CERTIFICATE = "update_certificate";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Relationship {
        public static final String EXIST_RELATIONSHIP_BY_ID = "exist_relationship_by_id";
        public static final String CREATE_RELATIONSHIP = "create_relationship";
        public static final String GET_RELATIONSHIP_BY_ID = "get_relationship_by_id";
        public static final String GET_RELATIONSHIP_BY_EMPLOYEE_ID = "get_relationship_by_employee_id";
        public static final String GET_ALL_RELATIONSHIP = "get_all_relationship";
        public static final String DELETE_BY_RELATIONSHIP_BY_ID = "delete_relationship_by_id";
        public static final String EXIST_RELATIONSHIP_BY_POSTCODE = "exist_relationship_by_postcode";
        public static final String UPDATE_RELATIONSHIP = "update_relationship";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class SalaryIncrement {
        public static final String CREATE_SALARY_INCREMENT = "create_salary_increment";
        public static final String EXIST_SALARY_INCREMENT_BY_ID = "exist_salary_increment_by_id";
        public static final String GET_SALARY_INCREMENT_BY_ID = "get_salary_increment_by_id";
        public static final String GET_ALL_SALARY_INCREMENT = "get_all_salary_increment";
        public static final String DELETE_SALARY_INCREMENT_BY_ID = "delete_salary_increment_by_id";
        public static final String UPDATE_SALARY_INCREMENT_BY_MANAGER = "update_salary_increment_by_id";
        public static final String SUBMIT_SALARY_INCREMENT = "submit_salary_increment";
        public static final String UPDATE_SALARY_INCREMENT_BY_LEADER = "update_salary_increment_by_leader";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Promotion {
        public static final String CREATE_PROMOTION = "create_promotion";
        public static final String EXIST_PROMOTION_BY_ID = "exist_promotion_by_id";
        public static final String GET_PROMOTION_BY_ID = "get_promotion_by_id";
        public static final String GET_ALL_PROMOTION = "get_all_promotion";
        public static final String DELETE_PROMOTION_BY_ID = "delete_promotion_by_id";
        public static final String UPDATE_PROMOTION_BY_MANAGER = "update_promotion_by_manager";
        public static final String SUBMIT_PROMOTION = "submit_promotion";
        public static final String UPDATE_PROMOTION_BY_LEADER = "update_promotion_by_leader";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ProposalAdvice {
        public static final String CREATE_PROPOSAL_ADVICE = "create_proposal";
        public static final String EXIST_PROPOSAL_ADVICE_BY_ID = "exist_proposal_by_id";
        public static final String GET_PROPOSAL_ADVICE_BY_ID = "get_proposal_by_id";
        public static final String GET_ALL_PROPOSAL = "get_all_proposal";
        public static final String DELETE_PROPOSAL_BY_ID = "delete_proposal_by_id";
        public static final String UPDATE_PROPOSAL_BY_MANAGER = "update_proposal_by_manager";
        public static final String SUBMIT_PROPOSAL = "submit_proposal";
        public static final String UPDATE_PROPOSAL_BY_LEADER = "update_proposal_by_leader";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Registration {
        public static final String CREATE_REGISTRATION = "create_registration";
        public static final String EXIST_REGISTRATION_BY_ID = "exist_registration_by_id";
        public static final String GET_REGISTRATION_BY_ID = "get_registration_by_id";
        public static final String GET_ALL_REGISTRATION = "get_all_registration";
        public static final String DELETE_REGISTRATION_BY_ID = "delete_registration_by_id";
        public static final String UPDATE_REGISTRATION_BY_MANAGER = "update_registration_by_manager";
        public static final String SUBMIT_REGISTRATION = "submit_registration";
        public static final String UPDATE_REGISTRATION_BY_LEADER = "update_registration_by_leader";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ProfileEnd {
        public static final String CREATE_PROFILE_END = "create_profile_end";
        public static final String EXIST_PROFILE_END_BY_ID = "exist_profile_end_by_id";
        public static final String GET_PROFILE_END_BY_ID = "get_profile_end_by_id";
        public static final String GET_ALL_PROFILE_END = "get_all_profile_end";
        public static final String DELETE_PROFILE_END_BY_ID = "delete_profile_end_by_id";
        public static final String UPDATE_PROFILE_END_BY_MANAGER = "update_profile_end_by_manager";
        public static final String SUBMIT_PROFILE_END = "submit_profile_end";
        public static final String UPDATE_PROFILE_END_BY_LEADER = "update_profile_end_by_leader";
        public static final String EXIST_PROFILE_END_BY_STORAGE_NUMBER = "exist_profile_end_by_storage_number";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Authenticator {
        public static final String EXIST_LEADER_BY_ID = "exist_leader_by_id";
    }
}
