package com.vidasoft.magman.model;

import java.util.Objects;

public class Advertiser {

    private String name;
    private String website;
    private String contactEmail;
    private byte[] logo;
    private SponsorPackage sponsorPackage;

    public Advertiser() {
    }

    public Advertiser(String name, String website, String contactEmail, SponsorPackage sponsorPackage) {
        this(name, website, contactEmail, null, sponsorPackage);
    }

    public Advertiser(String name, String website, String contactEmail, byte[] logo, SponsorPackage sponsorPackage) {
        this.name = name;
        this.website = website;
        this.contactEmail = contactEmail;
        this.logo = logo;
        this.sponsorPackage = sponsorPackage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public SponsorPackage getSponsorPackage() {
        return sponsorPackage;
    }

    public void setSponsorPackage(SponsorPackage sponsorPackage) {
        this.sponsorPackage = sponsorPackage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertiser that = (Advertiser) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(website, that.website) &&
                Objects.equals(contactEmail, that.contactEmail) &&
                sponsorPackage == that.sponsorPackage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, website, contactEmail, sponsorPackage);
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "name='" + name + '\'' +
                ", website='" + website + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", sponsorPackage=" + sponsorPackage +
                '}';
    }
}
