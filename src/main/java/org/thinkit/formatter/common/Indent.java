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

import org.thinkit.common.base.precondition.Preconditions;
import org.thinkit.formatter.common.catalog.IndentType;
import org.thinkit.formatter.common.helper.IndentHelper;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * インデントの処理と状態を管理するクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
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
    }

    /**
     * {@link Indent} クラスの新しいインスタンスを生成し返却します。
     *
     * @return {@link Indent} クラスの新しいインスタンス
     */
    private static Indent of() {
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
     * @since 1.0.0
     */
    public static class Builder {

        /**
         * インデント数
         */
        private int indent = 4;

        /**
         * インデントタイプ
         */
        private IndentType indentType = IndentType.SPACE;

        /**
         * デフォルトコンストラクタ
         */
        private Builder() {
        }

        /**
         * インデント数を設定します。
         * <p>
         * インデント数は正数を指定してください。
         * <p>
         * この {@link #withIndent(int)}
         * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
         *
         * @param indent インデント数
         * @return 自分自身のインスタンス
         */
        public Builder withIndent(int indent) {
            Preconditions.requirePositive(indent);
            this.indent = indent;
            return this;
        }

        /**
         * インデントタイプを設定します。
         * <p>
         * この {@link #withIndentType(IndentType)}
         * メソッドは自分自身のインスタンスを返却するため、後続処理をメソッドチェーンの形式で行うことができます。
         *
         * @param indentType インデント種別
         * @return 自分自身のインスタンス
         */
        public Builder withIndentType(@NonNull IndentType indentType) {
            this.indentType = indentType;
            return this;
        }

        /**
         * {@link #withIndent(int)} 、 {@link #withIndentType(IndentType)} メソッドで指定された値を基に
         * {@link Indent} クラスの新しいインスタンスを生成し返却します。各設定メソッドを呼び出さずに {@link #build()}
         * メソッドを呼び出した場合は初期値が優先的に使用されます。
         *
         * @return {@link Indent} クラスの新しいインスタンス
         */
        public Indentable build() {

            final Indent indent = Indent.of();
            indent.indent = IndentHelper.from(this.indentType).getIndent(this.indent);
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

    @Override
    public Indentable reset() {
        this.indentFactor = 0;
        return this;
    }
}
