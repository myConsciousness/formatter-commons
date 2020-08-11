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

import org.thinkit.common.Precondition;
import org.thinkit.common.catalog.Indentation;
import org.thinkit.common.exception.IllegalNumberFoundException;
import org.thinkit.formatter.common.catalog.IndentType;

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
        this.indent = Indentation.getIndentTabs();
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
     * {@link Builder} クラスの新しいインスタンスを生成し返却します。
     *
     * @return {@link Builder} クラスの新しいインスタンス
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * 各設定値に基づいて {@link Indent} クラスの新しいインスタンスを生成するビルダークラスです。
     *
     * @author Kato Shinya
     * @since 1.0
     * @version 1.0
     */
    public static class Builder {

        /**
         * インデント数
         */
        private int indent = 1;

        /**
         * インデントタイプ
         */
        private IndentType indentType = IndentType.TAB;

        /**
         * デフォルトコンストラクタ
         */
        private Builder() {
        }

        /**
         * インデント数を設定します。インデント数は正数を指定してください。 {@link #withIndent(int)}
         * メソッドに引数として負数が渡された場合は {@link IllegalNumberFoundException} が必ず実行時に発生します。
         * <p>
         * この {@link #withIndent(int)}
         * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
         *
         * @param indent インデント数
         * @return 自分自身のインスタンス
         *
         * @throws IllegalNumberFoundException 引数として渡された {@code indent} が負数の場合
         */
        public Builder withIndent(int indent) {
            Precondition.requirePositive(indent);
            this.indent = indent;
            return this;
        }

        /**
         * インデントタイプを空白に設定します。
         * <p>
         * この {@link #toIndentSpace()}
         * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
         *
         * @return 自分自身のインスタンス
         */
        public Builder toIndentSpace() {
            this.indentType = IndentType.SPACE;
            return this;
        }

        /**
         * インデントタイプをタブに設定します。
         * <p>
         * この {@link #toIndentTab()} メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
         *
         * @return 自分自身のインスタンス
         */
        public Builder toIndentTab() {
            this.indentType = IndentType.TAB;
            return this;
        }

        /**
         * {@link #withIndent(int)} 、 {@link #toIndentSpace()} 、 {@link #toIndentTab()}
         * メソッドで指定された値を基に {@link Indent} クラスの新しいインスタンスを生成し返却します。各設定メソッドを呼び出さずに
         * {@link #build()} メソッドを呼び出した場合は初期値が優先的に使用されます。
         *
         * @return {@link Indent} クラスの新しいインスタンス
         */
        public Indentable build() {
            final Indent indent = Indent.of();

            indent.indent = switch (this.indentType) {
                case SPACE -> Indentation.getIndentSpaces(this.indent);
                default -> Indentation.getIndentTabs(this.indent);
            };

            indent.indentFactor = 0;

            return indent;
        }
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