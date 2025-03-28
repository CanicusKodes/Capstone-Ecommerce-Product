package com.project.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ProductApplication{

//    private MentorRepository repository;
//    private StudentRepository studentRepository;
//    private TaRepository taRepository;
//    private UserRepository userRepository;
//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;
//    private final PriceRepository priceRepository;

    //    ProductApplication(@Qualifier("tpc_mentorRepository") MentorRepository repository) {
//        this.repository = repository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
//
//    @Override
//    //@Transactional
//    public void run(ApplicationArguments args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Rishabh");
//        mentor.setEmail("rishabh@gmail.com");
//        mentor.setAvgRating(4.5);
//        repository.save(mentor);
//        Student student = new Student();
//        student.setName("Rishabh");
//        student.setEmail("rishabh2@gmail.com");
//        student.setPspRating(100.0);
//        studentRepository.save(student);
//        Ta ta = new Ta();
//        ta.setName("Rishabh");
//        ta.setEmail("rishabh3@gmail.com");
//        ta.setTaRating(99.0);
//        taRepository.save(ta);
//        User user = new User();
//        user.setName("Rishabh");
//        user.setEmail("rishabh4@gmail.com");
//        userRepository.save(user);
//
//        List<User> users = userRepository.findAll();
//        for (User user1 : users) {
//
//        }
//
//        Category category = new Category();
//        category.setName("Electronics");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setValue(1000.0);
//        price.setCurrency("INR");
//
//        Product product = new Product();
//        product.setName("Laptop");
//        product.setDescription("Dell Laptop");
//        product.setCategory(savedCategory);
//        product.setPrice(price);
//
//        productRepository.save(product);


//        List<Product> product = productRepository.findAllByNameAndDescription("Laptop", "Dell Laptop");
//
//        System.out.println(product);
}
