package cn.lastlysly.pojo;

public class RoleSheet {
    private Long roleId;

    private String roleUsername;

    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleUsername() {
        return roleUsername;
    }

    public void setRoleUsername(String roleUsername) {
        this.roleUsername = roleUsername == null ? null : roleUsername.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}