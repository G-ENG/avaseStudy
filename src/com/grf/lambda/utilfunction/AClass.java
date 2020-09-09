package com.grf.lambda.utilfunction;
import java.util.function.*;

/**
 * 以下是 functionInterface 基本命名准则：
 *
 * 如果只处理对象而非基本类型，名称则为 Function，Consumer，Predicate 等。参数类型通过泛型添加。
 *
 * 如果接收的参数是基本类型，则由名称的第一部分表示，如 LongConsumer，DoubleFunction，IntPredicate 等，但基本 Supplier 类型例外。
 *
 * 如果无返回类型，则用 Consumer
 *
 * 如果返回值为基本类型，则用 To 表示，如 ToLongFunction <T> 和 IntToLongFunction。
 *
 * 如果返回值类型与参数类型一致，则是一个运算符：单个参数使用 UnaryOperator，两个参数使用 BinaryOperator。
 *
 * 如果接收两个参数且返回值为布尔值，则是一个谓词（Predicate）。
 *
 * 如果接收的两个参数类型不同，则名称中有一个 Bi。
 */
public class AClass {
    void useIntConsumer(IntConsumer intConsumer){

    }
}
