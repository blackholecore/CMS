/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import static context.DBContext.getConnection;
import entity.User;
import entity.Category;
import entity.Post;
import entity.PostComment;
import entity.Tag;
import entity.Advertisement;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author pc
 */
public class PostDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //lấy tất cả danh sách Comment
    public List<PostComment> getAllComment() {
        List<PostComment> list = new ArrayList<>();
        String query = "select * from post_comment";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {// L S D B D S S S S L 
                list.add(new PostComment(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<PostComment> getAllComment2() {
        List<PostComment> list = new ArrayList<>();
        String query = "select * from post_comment";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {// L S D B D S S S S L 
                list.add(new PostComment(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //lấy ra tất cả comment theo mã bài viết
    public List<PostComment> getCommentByPostID(Long cid) {
        List<PostComment> list = new ArrayList<>();
        String query = "select * from post_comment\n"
                + "where post_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new PostComment(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getLong(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //lấy ra tất ra danh sách quảng cáo có điều kiện trạng thái true và lấy ra top 4 ngẫu nhiên
    public List<Advertisement> getAllAdvertisement() {
        List<Advertisement> list = new ArrayList<>();
        String query = "select * from advertisement where status = true ORDER BY RAND() LIMIT 4";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {// L S D D D B
                list.add(new Advertisement(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getBoolean(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //lấy ra tất ra danh sách quảng cáo
    public List<Advertisement> getAllAdvertisement2() {
        List<Advertisement> list = new ArrayList<>();
        String query = "select * from advertisement";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {// L S D D D B
                list.add(new Advertisement(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getBoolean(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //ok
    public List<Advertisement> getAdvertisementById(Long ad_id) {
        List<Advertisement> list = new ArrayList<>();
        String query = "select * from advertisement where status = true and banner_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, ad_id);
            rs = ps.executeQuery();
            while (rs.next()) {// L S D D D B
                list.add(new Advertisement(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getBoolean(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String query = "select * from user";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {// L S S S B B B
                    list.add(new User(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getBoolean(5),
                            rs.getBoolean(6),
                            rs.getBoolean(7)
                    ));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<User> getAllUser2() {
        List<User> list = new ArrayList<>();
        String query = "select * from user";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {// L S D B S S S S S B B B
                    list.add(new User(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getBoolean(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getBoolean(10),
                            rs.getBoolean(11),
                            rs.getBoolean(12)
                    ));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<User> getUserById(Long uid) {
        List<User> list = new ArrayList<>();
        String query = "select * from user where user_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, uid);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {// L S D B S S S S S B B B
                    list.add(new User(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getBoolean(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getBoolean(10),
                            rs.getBoolean(11),
                            rs.getBoolean(12)
                    ));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<>();
        String query = "select * from post where published = true";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getTop6() {
        List<Post> list = new ArrayList<>();
        String query = "select * from post where published = true limit 6";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {// L S S S D B D S
                    list.add(new Post(
                            rs.getLong(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getDate(6),
                            rs.getBoolean(7),
                            rs.getDate(8),
                            rs.getString(9)
                    ));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getTop9(Long cid) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post\n"
                + "where category_id = ? limit 9";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getPostByCategoryID(Long cid) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post\n"
                + "where category_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getPostByUserID(Long uid) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post\n"
                + "where user_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, uid);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getBoolean(6),
                        rs.getDate(7),
                        rs.getString(8)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> searchPostByName(String txtSearch) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post WHERE post_title like '%" + txtSearch + "%'";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            //ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getPostByID(Long id) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post where post_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
//                return new Post(
//                        rs.getLong(1),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getDate(5),
//                        rs.getBoolean(6),
//                        rs.getDate(7),
//                        rs.getString(8));
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Post> getPostById(Long id) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post where post_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9),
                        rs.getLong(10),
                        rs.getInt(11),
                        rs.getLong(12)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //ok
    public List<Post> getPostBySLUGID(String slugid) {
        List<Post> list = new ArrayList<>();
        String query = "select * from post where concat(slug,'-',post_id) = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, slugid);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S
                list.add(new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }
//    private Connection connection;
//
//    public Post getPostById(Long postId) {
//        Post post = new Post();
//        try {
//            PreparedStatement preparedStatement = connection.
//                    prepareStatement("select * from post where post_id = '?'");
//            preparedStatement.setLong(1, postId);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            if (rs.next()) {
//                post.setPostId(rs.getLong("post_id"));
//                post.setPostTitle(rs.getString("post_title"));
//                post.setSlug(rs.getString("slug"));
//                post.setThumbnail(rs.getString("thumbnail"));
//                post.setUpdatedAt(rs.getDate("updatedAt"));
//                post.setPublished(rs.getBoolean("published"));
//                post.setUpdatedAt(rs.getDate("publishedAt"));
//                post.setContent(rs.getString("content"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return post;
//    }

    //ok
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Category> getAllCategory2() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Category> getCategoryById(Long id) {
        List<Category> list = new ArrayList<>();
        String query = "select * from category where category_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Tag> getTagById(Long id) {
        List<Tag> list = new ArrayList<>();
        String query = "select * from tag where tag_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Tag(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getLong(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //ok
    public List<Tag> getAllTag() {
        List<Tag> list = new ArrayList<>();
        String query = "select * from tag";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Tag(rs.getLong(1),
                        rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Post getPostLast() {
        String query = "select * from post order by post_id desc limit 1";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S D B D S S
                return new Post(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(6),
                        rs.getBoolean(7),
                        rs.getDate(8),
                        rs.getString(9)
                );
            }
        } catch (Exception e) {
        }
        return null;
    }

    public User login(String email, String pass) throws NoSuchAlgorithmException {
        String passhash = convertHashToString(pass);
        String query = "select * from user\n"
                + "where email = ?\n"
                + "and password = ? and isAdmin = '1' and status = '1'";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, passhash);
            rs = ps.executeQuery();
            while (rs.next()) {// L S S S B B B
                return new User(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static String convertHashToString(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static boolean verify(String inputPassword, String hashPassWord) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(inputPassword.getBytes());
        byte[] digest = md.digest();
        String myChecksum = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return hashPassWord.equals(myChecksum);
    }

    //ok
    public User checkAccountExist(String email) {
        String query = "select * from user\n"
                + "where email = ?\n";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String email, String pass, String fullname) throws NoSuchAlgorithmException {
        String passhash = convertHashToString(pass);
        String query = "INSERT INTO `user`(`fullname`, `email`, `password`, `status`, `isMember`, `isAdmin`) VALUES (?,?,?,'1','1','0')";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setString(2, email);
            ps.setString(3, passhash);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //START CRUD Post
    public void deletePost(Long post_id) {
        String query = "DELETE FROM `post` WHERE `post`.`post_id` = " + post_id.intValue();
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            //ps.setLong(1, post_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertPost(String postTitle, String slug, String thumbnail, String summary, Date updatedAt, boolean published, Date publishedAt, String content, Long user_id, int viewCount, Long category_id) {
        String query = "INSERT INTO `post`(`post_title`, `slug`, `thumbnail`, `summary`, `updatedAt`, `published`, `publishedAt`, `content`, `user_id`, `viewcount`, `category_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, postTitle);
            ps.setString(2, slug);
            ps.setString(3, thumbnail);
            ps.setString(4, summary);
            ps.setDate(5, updatedAt);
            ps.setBoolean(6, published);
            ps.setDate(7, publishedAt);
            ps.setString(8, content);
            ps.setLong(9, user_id);
            ps.setInt(10, viewCount);
            ps.setLong(11, category_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editPost(Long postId, String postTitle, String slug, String thumbnail, String summamry, Date updatedAt, boolean published, Date publishedAt, String content, Long user_id, int viewcount, Long category_id) {
        String query = "UPDATE `post` SET `post_title`=?,`slug`=?,`thumbnail`=?,`summary`=?,`updatedAt`=?,`published`=?,`publishedAt`=?,`content`=?,`user_id`=?,`viewcount`=?,`category_id`=? WHERE post_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            ps.setString(1, postTitle);
            ps.setString(2, slug);
            ps.setString(3, thumbnail);
            ps.setString(4, thumbnail);
            ps.setDate(5, updatedAt);
            ps.setBoolean(6, published);
            ps.setDate(7, publishedAt);
            ps.setLong(8, user_id);
            ps.setInt(9, viewcount);
            ps.setLong(10, category_id);
            ps.setLong(11, user_id);
            ps.setLong(12, postId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //thay đổi trạng thái xuất bản
    public void updatePost(Long postId) {
        String query = "UPDATE `post` SET `published`= ?,`publishedAt`= CURDATE() WHERE post_id = ?";

        PostDAO dao = new PostDAO();
        Post post = dao.getPostByID(postId).get(0);
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            if (post.getPublished() == true) {
                ps.setBoolean(1, false);
                ps.setLong(2, postId);
            } else {
                ps.setBoolean(1, true);
                ps.setLong(2, postId);
            }
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //END CRUD Post
    // START CRUD Category
    
    //hàm xóa 1 chuyên mục bài viết theo ID Chuyên mục
    public void deleteCategory(Long category_id) {
        String query = "DELETE FROM 'category` WHERE `category`.`category_id` = " + category_id.intValue();
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            //ps.setLong(1, category_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //hàm thêm mới 1 chuyên mục bài viết
    public void insertCategory(String cat_title, String slug, String icon) {
        String query = "INSERT INTO `category`(`cat_title`, `slug`, `icon`) VALUES (?,?,?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, cat_title);
            ps.setString(2, slug);
            ps.setString(3, icon);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //hàm sửa chuyên mục chủ đề bài viết
    public void editCategory(Long categoryId, String catTitle, String slug, String icon) {
        String query = "UPDATE `category` SET `cat_title`= ?,`slug`= ?,`icon`= ? WHERE category_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            ps.setString(1, catTitle);
            ps.setString(2, slug);
            ps.setString(3, icon);
            ps.setLong(4, categoryId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    // END CRUD Category

    // START CRUD Tag
    public void deleteTag(Long tag_id) {
        String query = "delete from tag\n"
                + "where tag_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, tag_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void insertTag(String tagTitle, Long post_id) {
        String query = "INSERT INTO `tag`(`tag_title`, `post_id`) VALUES (?,?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, tagTitle);
            ps.setLong(2, post_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editTag(Long tagId, String tagTitle, Long post_id) {
        String query = "UPDATE `tag` SET `tag_title`= ?,`post_id`= ? WHERE tag_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            ps.setString(1, tagTitle);
            ps.setLong(2, post_id);
            ps.setLong(3, tagId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    // END CRUD Tag

    // START CRUD PostComment
    public void deleteComment(Long post_comment_id) {
        String query = "delete from post_comment\n"
                + "where post_comment_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, post_comment_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertComment(String comment_title, Date updatedAt, Boolean published, Date publishedAt, String content, Long post_id, String comment_email, String comment_website, String comment_fullname) throws NoSuchAlgorithmException {
        
        String query = "INSERT INTO `post_comment`(`comment_title`, `updatedAt`, `published`, `publishedAt`, `content`, `post_id`, `comment_email`, `comment_website`, `comment_fullname`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, comment_title);
            ps.setDate(2, updatedAt);
            ps.setBoolean(3, published);
            ps.setDate(4, publishedAt);
            ps.setString(5, content);
            ps.setLong(6, post_id);
            ps.setString(7, comment_email);
            ps.setString(8, comment_website);
            ps.setString(9, comment_fullname);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void insertAdvertisement(String image, String link, Date from_date, Date to_date, Date created_date, Boolean status) throws NoSuchAlgorithmException {
        
        String query = "INSERT INTO `advertisement`(`image`, `link`, `from_date`, `to_date`, `created_date`, `status`) VALUES (?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, image);
            ps.setString(2, link);
            ps.setDate(3, from_date);
            ps.setDate(4, to_date);
            ps.setDate(5, created_date);
            ps.setBoolean(6, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    // END CRUD PostComment
    // START CRUD User
    public void insertUser(String fullname, Date birthday, Boolean gender, String address, String email, String mobile, String password, String avatar, boolean status, boolean isMember, boolean isAdmin) throws NoSuchAlgorithmException {
        String passhash = convertHashToString(password);
        String query = "INSERT INTO `user`(`fullname`, `birthday`, `gender`, `address`, `email`, `mobile`, `password`, `avatar`, `status`, `isMember`, `isAdmin`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, fullname);
            ps.setDate(2, birthday);
            ps.setBoolean(3, gender);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, mobile);
            ps.setString(7, passhash);
            ps.setString(8, avatar);
            ps.setBoolean(9, status);
            ps.setBoolean(10, isMember);
            ps.setBoolean(11, isAdmin);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editUser(Long userId, String fullname, Date birthday, Boolean gender, String address, String email, String mobile, String password, String avatar, boolean status, boolean isMember, boolean isAdmin) throws NoSuchAlgorithmException {
        String passhash = convertHashToString(password);
        String query = "UPDATE `user` SET `fullname`=?,`birthday`=?,`gender`=?,`address`=?,`email`=?,`mobile`=?,`password`=?,`avatar`=?,`status`=?,`isMember`=?,`isAdmin`=? WHERE user_id = ?";
        PostDAO dao = new PostDAO();
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            ps.setString(1, fullname);
            ps.setDate(2, birthday);
            ps.setBoolean(3, gender);
            ps.setString(4, address);
            ps.setString(5, email);
            ps.setString(6, mobile);
            ps.setString(7, passhash);
            ps.setString(8, avatar);
            ps.setBoolean(9, status);
            ps.setBoolean(10, isMember);
            ps.setBoolean(11, isAdmin);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteUser(Long user_id) {
        String query = "delete from user\n"
                + "where post_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, user_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //thay đổi trạng thái xuất bản
    public void updateUser(Long userId) {
        String query = "UPDATE `user` SET `status`= ? WHERE user_id = ?";

        PostDAO dao = new PostDAO();
        User user = dao.getUserById(userId).get(0);
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            if (user.getStatus() == true) {
                ps.setBoolean(1, false);
                ps.setLong(2, userId);
            } else {
                ps.setBoolean(1, true);
                ps.setLong(2, userId);
            }
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //thay đổi trạng thái xuất bản
    public void updateUser_Admin(Long userId) {
        String query = "UPDATE `user` SET `isAdmin`= ? WHERE user_id = ?";

        PostDAO dao = new PostDAO();
        User user = dao.getUserById(userId).get(0);
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            if (user.getIsAdmin() == true) {
                ps.setBoolean(1, false);
                ps.setLong(2, userId);
            } else {
                ps.setBoolean(1, true);
                ps.setLong(2, userId);
            }
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //thay đổi trạng thái xuất bản
    public void updateUser_Member(Long userId) {
        String query = "UPDATE `user` SET `isMember`= ? WHERE user_id = ?";

        PostDAO dao = new PostDAO();
        User user = dao.getUserById(userId).get(0);
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            if (user.getIsMember() == true) {
                ps.setBoolean(1, false);
                ps.setLong(2, userId);
            } else {
                ps.setBoolean(1, true);
                ps.setLong(2, userId);
            }
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //1 số hàm khác
    
     public void updateAdvertisement(Long adId) {
        String query = "UPDATE `advertisement` SET `status`= ? WHERE banner_id = ?";

        PostDAO dao = new PostDAO();
        Advertisement ad = dao.getAdvertisementById(adId).get(0);
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query); // S S S D B D S I I I
            if (ad.getStatus() == true) {
                ps.setBoolean(1, false);
                ps.setLong(2, adId);
            } else {
                ps.setBoolean(1, true);
                ps.setLong(2, adId);
            }
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void deleteAdvertisement(Long banner_id) {
        String query = "delete from advertisement\n"
                + "where banner_id = ?";
        try {
            conn = DBContext.getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setLong(1, banner_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    
    
    // END CRUD User
    public static void main(String[] args) throws Exception {
        PostDAO dao = new PostDAO();
        System.out.println(convertHashToString("khoa69"));
        User a;
        a = dao.login("khoaruoi69@gmail.com", "khoa69");
        if (a == null) {
        } else {
            System.out.println(a.getFullname());
        }
        
//        List<User> user = dao.getUserById(2L);
//        System.out.println(user.get(0).getEmail());
//        List<Advertisement> listCC = dao.getAllAdvertisement();
//        for(Advertisement c: listCC){
//            System.out.println(c.getImage());
//        }
//        String txtSearch = "Windows";
//        List<Post> list = dao.searchPostByName(txtSearch);
//        if (list != null) {
//            for (Post p : list) {
//                System.out.println(p.getPostTitle());
//            }
//        }
//        String pid = "36";
//        dao.deletePost(Long.parseLong(pid));
//        System.out.println(dao.getPostByID(Long.parseLong(pid)).get(0).getPostTitle());
//        List<Post> listCC = dao.getAllPost();
//        for(Post c: listCC){
//            System.out.println(c.getPostTitle());
//        }
//        System.out.println("\n\n");
//        System.out.println(dao.getPostByID(6L).get(0).getPostTitle());
//        System.out.println(dao.getCategoryById(1L).get(0).getCatTitle());
//        
//        User a = null;
//        if(dao.login("huynh.it.24@gmail.com", "huynh69") != null){
//            a = dao.login("huynh.it.24@gmail.com", "huynh69");
//            System.out.println(a.getFullname()+"\n");
//        }
//        if(dao.checkAccountExist("huynh.it.24@gmail.com") != null){
//            System.out.println("Email này đã tồn tại\n");
//        }
//        dao.singup("ducdat69@gmail.com", "dat09", "Nguyễn Đức Đạt");
//        if (dao.checkAccountExist("ducdat69@gmail.com") != null) {
//            System.out.println("Email này đã tồn tại\n");
//        }
        //dao.insertPost("Win 11", "win-11", "win-11.jpg","Đang viết", Date.from(Instant.now()), true, Date.from(Instant.now()), "Test Demo", 2L, 0, 6L);
        //System.out.println(dao.getPostByID(32L).get(0).getPostTitle());
//        for(PostComment item : dao.getAllComment()){
//            System.out.println(item.getCommentTitle());
//        }
//        System.out.println(Boolean.parseBoolean("True"));
    }
}
