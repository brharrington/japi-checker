/*
 * Copyright 2012 William Bernardet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.japi.checker;

import java.util.logging.Logger;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.googlecode.japi.checker.model.MethodData;

public class MethodDumper extends MethodVisitor {
    private Logger logger = Logger.getLogger(MethodDumper.class.getName());
    private final MethodData method;
    
    public MethodDumper(MethodData method) {
        super(Opcodes.ASM4);
        this.method = method;
    }
    
    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        return new AnnotationDumper(method, desc, visible);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        return null;
    }

    @Override
    public void visitAttribute(Attribute arg0) {
    }

    @Override
    public void visitCode() {
    }

    @Override
    public void visitEnd() {
    }

    @Override
    public void visitFieldInsn(int arg0, String arg1, String arg2, String arg3) {
    }

    @Override
    public void visitFrame(int arg0, int arg1, Object[] arg2, int arg3,
            Object[] arg4) {
    }

    @Override
    public void visitIincInsn(int arg0, int arg1) {
    }

    @Override
    public void visitInsn(int arg0) {
    }

    @Override
    public void visitIntInsn(int arg0, int arg1) {
    }

    @Override
    public void visitJumpInsn(int arg0, Label arg1) {
    }

    @Override
    public void visitLabel(Label arg0) {
    }

    @Override
    public void visitLdcInsn(Object arg0) {
    }

    @Override
    public void visitLineNumber(int line, Label start) {
        logger.fine("       @" + line);
        method.setLineNumber(line);
    }

    @Override
    public void visitLocalVariable(String arg0, String arg1, String arg2,
            Label arg3, Label arg4, int arg5) {
    }

    @Override
    public void visitLookupSwitchInsn(Label arg0, int[] arg1, Label[] arg2) {
    }

    @Override
    public void visitMaxs(int arg0, int arg1) {
    }

    @Override
    public void visitMethodInsn(int arg0, String arg1, String arg2, String arg3) {
    }

    @Override
    public void visitMultiANewArrayInsn(String arg0, int arg1) {
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int arg0, String arg1,
            boolean arg2) {
        return null;
    }

    @Override
    public void visitTableSwitchInsn(int arg0, int arg1, Label arg2,
            Label... arg3) {
    }

    @Override
    public void visitTryCatchBlock(Label arg0, Label arg1, Label arg2,
            String arg3) {
    }

    @Override
    public void visitTypeInsn(int arg0, String arg1) {
    }

    @Override
    public void visitVarInsn(int arg0, int arg1) {
    }

}
