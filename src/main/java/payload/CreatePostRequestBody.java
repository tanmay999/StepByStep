package payload;

import pojo.CreateProjectPojoRequest.Category;
import pojo.CreateProjectPojoRequest.CreatePetRoot;
import pojo.CreateProjectPojoRequest.Tag;
import utils.helper_Util.SerializationHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatePostRequestBody {


      public CreatePetRoot postPetRequestBody(){

            Random random = new Random();
            int ranNo=random.nextInt(1000);
            List<Tag> tagList= new ArrayList<>();
            Tag tag = new Tag();
            tag.setId(ranNo);
            tag.setName("german shepherad");
            tagList.add(tag);



            Category category = new Category();
            category.setId(1);
            category.setName("HJBCJBvjhbjbKJD");

            List<String>  photoUrl = new ArrayList<>();
            photoUrl.add("jhbcjndjkn");
            CreatePetRoot createPetRoot = new CreatePetRoot();
            createPetRoot.setCategory(category);
            createPetRoot.setTags(tagList);
            createPetRoot.setPhotoUrls(photoUrl);
            createPetRoot.setName("vjhcbkjsdsnk");
            createPetRoot.setId(7890);
            createPetRoot.setStatus("available");

            return  createPetRoot;

      }

      public CreatePetRoot postPetRequestBodyFromFile() throws IOException {

            SerializationHelper serializationHelper = new SerializationHelper();
            String filepath="C:\\Users\\tanma\\Documents\\StepByStep\\src\\test\\resources\\jsonFiles\\PostRequest1.json";
            CreatePetRoot reqStr= (CreatePetRoot) serializationHelper.DeserializeJsonFileToPojo(filepath);
                  return reqStr;
      }



}
