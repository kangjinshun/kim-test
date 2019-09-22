package plugin.compile;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author kangjinshun
 * @create 2019/9/21
 * @since 1.0.0
 */
// 代表了这个注解处理器对哪些注解感兴趣，可以使用*作为通配符代表对所有的注解都敢兴趣
@SupportedAnnotationTypes("*")
// 指出这个注解处理器可以处理哪些版本的java代码 只支持JDK1.8的java代码
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameCheckProcessor extends AbstractProcessor {

    private NameChecker nameChecker;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        nameChecker = new NameChecker(processingEnv);
    }

    /**
     * 对输入的语法树的各个节点进行名称检查
     *
     * @param annotations 可以获取到此注解处理器所要处理的注解集合
     * @param roundEnv    可以访问到当前这个Round中的语法树节点，每个语法树节点在这里表示一个Element
     * @return 由于本次只是对程序中命名进行检查，不需要改变语法树的内容，所以返回false.
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            for (Element element : roundEnv.getRootElements()) {
                nameChecker.checkNames(element);
            }
        }
        return false;
    }
}
