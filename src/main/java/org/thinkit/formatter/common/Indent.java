/*
 * Copyright 2020 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.thinkit.formatter.common;

import org.thinkit.common.catalog.Indentation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * インデントの処理と状態を管理するクラスです。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@ToString
@EqualsAndHashCode
public final class Indent implements Indentable {

    /**
     * インデント数分の空白またはタブ
     */
    @Getter
    private String indent;

    /**
     * インデントファクター
     */
    @Getter
    private int indentFactor;

    /**
     * デフォルトコンストラクタ
     */
    private Indent() {
        this.indent = Indentation.getIndentSpaces();
        this.indentFactor = 0;
    }

    /**
     * コンストラクタ
     *
     * @param indent インデント数
     */
    private Indent(int indent) {
        this.indent = Indentation.getIndentSpaces(indent);
        this.indentFactor = 0;
    }

    /**
     * {@link Indent} クラスの新しいインスタンスを生成し返却します。
     *
     * @return {@link Indent} クラスの新しいインスタンス
     */
    public static Indent of() {
        return new Indent();
    }

    /**
     * 引数として指定された {@code indent} の数値に応じた {@link Indent} クラスの新しいインスタンスを生成し返却します。
     *
     * @param indent インデント数
     * @return {@link Indent} クラスの新しいインスタンス
     */
    public static Indent of(int indent) {
        return new Indent(indent);
    }

    @Override
    public Indentable increment() {
        this.indentFactor++;
        return this;
    }

    @Override
    public Indentable decrement() {
        this.indentFactor--;
        return this;
    }
}