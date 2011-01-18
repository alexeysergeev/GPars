// GPars - Groovy Parallel Systems
//
// Copyright © 2008-11  The original author or authors
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package groovyx.gpars.activeobject;

import org.codehaus.groovy.ast.ASTNode;
import org.codehaus.groovy.control.CompilePhase;
import org.codehaus.groovy.control.SourceUnit;
import org.codehaus.groovy.transform.ASTTransformation;
import org.codehaus.groovy.transform.GroovyASTTransformation;

/**
 * @author Vaclav Pech
 *
 * Inspired by org.codehaus.groovy.transform.LogASTTransformation
 */
@GroovyASTTransformation(phase = CompilePhase.CANONICALIZATION)
class ActiveObjectASTTransformation implements ASTTransformation {
    @Override
    public void visit(final ASTNode[] nodes, final SourceUnit source) {
        System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
//        if (nodes.length != 2 || !(nodes[0] instanceof AnnotationNode) || !(nodes[1] instanceof AnnotatedNode)) {
//            addError("Internal error: expecting [AnnotationNode, AnnotatedNode] but got: " + Arrays.asList(nodes), nodes[0], source);
//        }

//        final AnnotatedNode targetClass = (AnnotatedNode) nodes[1];
//        final AnnotationNode activeObjectAnnotation = (AnnotationNode) nodes[0];
//
//        final String actorFieldName = lookupLogFieldName(activeObjectAnnotation);
//
//        if (!(targetClass instanceof ClassNode))
//            throw new GroovyBugError("Class annotation " + activeObjectAnnotation.getClassNode().getName() + " annotated no Class, this must not happen.");
//
//        final ClassNode classNode = (ClassNode) targetClass;
//
//        System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
//        final GroovyClassVisitor transformer = new MyClassCodeExpressionTransformer(source, actorFieldName);
//        transformer.visitClass(classNode);
    }

//    private static String lookupLogFieldName(final AnnotationNode logAnnotation) {
//        final Expression member = logAnnotation.getMember("value");
//        if (member != null && member.getText() != null) {
//            return member.getText();
//        } else {
//            return "internalActiveObjectActor";
//        }
//    }
//
//    public static void addError(final String msg, final ASTNode expr, final SourceUnit source) {
//        final int line = expr.getLineNumber();
//        final int col = expr.getColumnNumber();
//        source.getErrorCollector().addErrorAndContinue(
//                new SyntaxErrorMessage(new SyntaxException(msg + '\n', line, col), source)
//        );
//    }

//    @SuppressWarnings({"StringToUpperCaseOrToLowerCaseWithoutLocale", "CallToStringEquals"})
//    private static class MyClassCodeExpressionTransformer extends ClassCodeExpressionTransformer {
//        private FieldNode actorNode;
//        private final SourceUnit source;
//        private final String actorFieldName;
//
//        private MyClassCodeExpressionTransformer(final SourceUnit source, final String actorFieldName) {
//            this.source = source;
//            this.actorFieldName = actorFieldName;
//        }
//
//        @Override
//        protected SourceUnit getSourceUnit() {
//            return source;
//        }
//
//        @Override
//        public Expression transform(final Expression exp) {
//            System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
//            if (exp == null) return null;
//            if (exp instanceof MethodCallExpression) {
//                return transformMethodCallExpression(exp);
//            }
//            return super.transform(exp);
//        }
//
//        @Override
//        public void visitClass(final ClassNode node) {
//            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAaaa");
//            final FieldNode logField = node.getField(actorFieldName);
//            if (logField != null) {
//                this.addError("Class annotated with Log annotation cannot have log field declared", logField);
//            } else {
//                actorNode = addActorFieldToClass(node, actorFieldName);
//            }
//            super.visitClass(node);
//        }
//
//        private Expression transformMethodCallExpression(final Expression exp) {
//            final MethodCallExpression mce = (MethodCallExpression) exp;
//            if (!(mce.getObjectExpression() instanceof VariableExpression)) {
//                return exp;
//            }
//            final VariableExpression variableExpression = (VariableExpression) mce.getObjectExpression();
//            if (!variableExpression.getName().equals(actorFieldName)
//                    || !(variableExpression.getAccessedVariable() instanceof DynamicVariable)) {
//                return exp;
//            }
//            final String methodName = mce.getMethodAsString();
//            if (methodName == null) return exp;
//            if (usesSimpleMethodArgumentsOnly(mce)) return exp;
//
//            variableExpression.setAccessedVariable(actorNode);
//
//            if (!isLoggingMethod(methodName)) return exp;
//
//            return wrapLoggingMethodCall(variableExpression, methodName, exp);
//        }
//
//        private static boolean usesSimpleMethodArgumentsOnly(final MethodCallExpression mce) {
//            final Expression arguments = mce.getArguments();
//            if (arguments instanceof TupleExpression) {
//                final TupleExpression tuple = (TupleExpression) arguments;
//                for (final Expression exp : tuple.getExpressions()) {
//                    if (!isSimpleExpression(exp)) return false;
//                }
//                return true;
//            }
//            return !isSimpleExpression(arguments);
//        }
//
//        private static boolean isSimpleExpression(final Expression exp) {
//            if (exp instanceof ConstantExpression) return true;
//            return exp instanceof VariableExpression;
//        }
//
//        private static FieldNode addActorFieldToClass(final ClassNode classNode, final String logFieldName) {
//            //todo make the field non-static
//            //todo pass in the group
//            return classNode.addField(logFieldName,
//                    Opcodes.ACC_FINAL | Opcodes.ACC_TRANSIENT | Opcodes.ACC_STATIC | Opcodes.ACC_PRIVATE,
//                    new ClassNode(InternalActor.class),
////                    new ClassNode("groovyx.gpars.activeobject.InternalActor", Opcodes.ACC_PUBLIC, new ClassNode(Object.class)),
//                    new MethodCallExpression(
//                            new ClassExpression(new ClassNode(InternalActor.class)),
//                            "create",
//                            new ClassExpression(classNode)));
//        }
//
//        private static boolean isLoggingMethod(final String methodName) {
//            return methodName.matches("fatal|error|warn|info|debug|trace");
//        }
//
//        private static Expression wrapLoggingMethodCall(final Expression logVariable, final String methodName, final Expression originalExpression) {
//            final MethodCallExpression condition = new MethodCallExpression(
//                    logVariable,
//                    "is" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1, methodName.length()) + "Enabled",
//                    ArgumentListExpression.EMPTY_ARGUMENTS);
//
//            return new TernaryExpression(
//                    new BooleanExpression(condition),
//                    originalExpression,
//                    ConstantExpression.NULL);
//        }
//    }
}

