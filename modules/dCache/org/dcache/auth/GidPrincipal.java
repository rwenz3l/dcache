package org.dcache.auth;

import java.security.Principal;

/**
 *
 * @author jans
 */
public class GidPrincipal implements Principal {

    private long _gid;
    private boolean _isPrimaryGroup;

    public GidPrincipal(long gid, boolean isPrimary) {
        _gid = gid;
        _isPrimaryGroup = isPrimary;
    }

    public GidPrincipal(String gid, boolean isPrimary) {
        this(Long.parseLong(gid), isPrimary);
    }

    public boolean isPrimaryGroup() {
        return _isPrimaryGroup;
    }

    public long getGid() {
        return _gid;
    }

    @Override
    public String getName() {
        return String.valueOf(_gid);
    }

    @Override
    public String toString() {
        return (getClass().getName() + "[gid=" +
                getName() + ",primay=" +
                String.valueOf(_isPrimaryGroup) + "]");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof GidPrincipal)) {
            return false;
        }
        GidPrincipal otherGid = (GidPrincipal) other;
        return (otherGid.getGid() == getGid() &&
                (otherGid.isPrimaryGroup() == isPrimaryGroup()));
    }

    @Override
    public int hashCode() {
        return ((int) _gid + (_isPrimaryGroup ? 1 : 0));
    }
}
