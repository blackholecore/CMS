/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "post_comment", catalog = "weblog", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostComment.findAll", query = "SELECT p FROM PostComment p")
    , @NamedQuery(name = "PostComment.findByPostCommentId", query = "SELECT p FROM PostComment p WHERE p.postCommentId = :postCommentId")
    , @NamedQuery(name = "PostComment.findByCommentTitle", query = "SELECT p FROM PostComment p WHERE p.commentTitle = :commentTitle")
    , @NamedQuery(name = "PostComment.findByUpdatedAt", query = "SELECT p FROM PostComment p WHERE p.updatedAt = :updatedAt")
    , @NamedQuery(name = "PostComment.findByPublished", query = "SELECT p FROM PostComment p WHERE p.published = :published")
    , @NamedQuery(name = "PostComment.findByPublishedAt", query = "SELECT p FROM PostComment p WHERE p.publishedAt = :publishedAt")
    , @NamedQuery(name = "PostComment.findByCommentEmail", query = "SELECT p FROM PostComment p WHERE p.commentEmail = :commentEmail")
    , @NamedQuery(name = "PostComment.findByCommentWebsite", query = "SELECT p FROM PostComment p WHERE p.commentWebsite = :commentWebsite")
    , @NamedQuery(name = "PostComment.findByCommentFullname", query = "SELECT p FROM PostComment p WHERE p.commentFullname = :commentFullname")})
public class PostComment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "post_comment_id", nullable = false)
    private Long postCommentId;
    @Basic(optional = false)
    @Column(name = "comment_title", nullable = false, length = 100)
    private String commentTitle;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean published;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
    @Basic(optional = false)
    @Lob
    @Column(nullable = false, length = 16777215)
    private String content;
    @Column(name = "comment_email", length = 254)
    private String commentEmail;
    @Column(name = "comment_website", length = 50)
    private String commentWebsite;
    @Column(name = "comment_fullname", length = 50)
    private String commentFullname;
    @JoinColumn(name = "post_id", referencedColumnName = "post_id", nullable = false)
    @ManyToOne(optional = false)
    private Post postId;
    private Long post_Id;

    public PostComment() {
    }

    public PostComment(Long postCommentId) {
        this.postCommentId = postCommentId;
    }

    public PostComment(Long postCommentId, String commentTitle, Date updatedAt, boolean published, Date publishedAt, String content) {
        this.postCommentId = postCommentId;
        this.commentTitle = commentTitle;
        this.updatedAt = updatedAt;
        this.published = published;
        this.publishedAt = publishedAt;
        this.content = content;
    }
    
    public PostComment(Long postCommentId, String commentTitle, Date updatedAt, boolean published, Date publishedAt, String content, Long post_id, String commentEmail, String commentWebsite, String commentFullname) {
        this.postCommentId = postCommentId;
        this.commentTitle = commentTitle;
        this.updatedAt = updatedAt;
        this.published = published;
        this.publishedAt = publishedAt;
        this.content = content;
        this.commentEmail = commentEmail;
        this.commentWebsite = commentWebsite;
        this.commentFullname = commentFullname;
        this.post_Id = post_id;
    }

    public Long getPostCommentId() {
        return postCommentId;
    }

    public void setPostCommentId(Long postCommentId) {
        this.postCommentId = postCommentId;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCommentEmail() {
        return commentEmail;
    }

    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail;
    }

    public String getCommentWebsite() {
        return commentWebsite;
    }

    public void setCommentWebsite(String commentWebsite) {
        this.commentWebsite = commentWebsite;
    }

    public String getCommentFullname() {
        return commentFullname;
    }

    public void setCommentFullname(String commentFullname) {
        this.commentFullname = commentFullname;
    }

//    public Post getPostId() {
//        return postId;
//    }
//
//    public void setPostId(Post postId) {
//        this.postId = postId;
//    }
    
    public Long getPostId() {
        return post_Id;
    }

    public void setPostId(Long postId) {
        this.post_Id = post_Id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postCommentId != null ? postCommentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostComment)) {
            return false;
        }
        PostComment other = (PostComment) object;
        if ((this.postCommentId == null && other.postCommentId != null) || (this.postCommentId != null && !this.postCommentId.equals(other.postCommentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PostComment[ postCommentId=" + postCommentId + " ]";
    }
    
}
