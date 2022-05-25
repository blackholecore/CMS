/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.PostDAO;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(catalog = "weblog", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t")
    , @NamedQuery(name = "Tag.findByTagId", query = "SELECT t FROM Tag t WHERE t.tagId = :tagId")
    , @NamedQuery(name = "Tag.findByTagTitle", query = "SELECT t FROM Tag t WHERE t.tagTitle = :tagTitle")})
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tag_id", nullable = false)
    private Long tagId;
    @Basic(optional = false)
    @Column(name = "tag_title", nullable = false, length = 60)
    private String tagTitle;
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    @ManyToOne(optional = false)
    private Post postId;

    public Tag() {
    }

    public Tag(Long tagId) {
        this.tagId = tagId;
    }

    public Tag(Long tagId, String tagTitle) {
        this.tagId = tagId;
        this.tagTitle = tagTitle;
    }
    
    public Tag(Long tagId, String tagTitle, Long postId) {
        PostDAO dao = new PostDAO();
        this.tagId = tagId;
        this.tagTitle = tagTitle;
        this.postId = dao.getPostByID(postId).get(0);
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagTitle() {
        return tagTitle;
    }

    public void setTagTitle(String tagTitle) {
        this.tagTitle = tagTitle;
    }

    public Post getPostId() {
        return postId;
    }

    public void setPostId(Post postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tagId != null ? tagId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.tagId == null && other.tagId != null) || (this.tagId != null && !this.tagId.equals(other.tagId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tag[ tagId=" + tagId + " ]";
    }
    
}
