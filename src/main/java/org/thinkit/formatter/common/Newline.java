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

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

/**
 * インデント数に応じた改行を管理するクラスです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
@ToString
@EqualsAndHashCode
public final class Newline implements Line {

    /**
     * 改行コード
     */
    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * インデント
     */
    private Indentable indent;

    /**
     * デフォルトコンストラクタ
     */
    private Newline() {
    }

    /**
     * コンストラクタ
     *
     * @param indent インデント
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    private Newline(@NonNull Indentable indent) {
        this.indent = indent;
    }

    /**
     * 引数として渡された {@code indent} に基づいた {@link Newline} クラスの新しいインスタンスを生成し返却します。
     *
     * @param indent インデント
     * @return {@link Newline} クラスの新しいインスタンス
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    public static Line of(@NonNull Indentable indent) {
        return new Newline(indent);
    }

    /**
     * インデント数に応じた改行コードを生成し返却します。
     *
     * @return インデント数に応じた改行コード
     */
    @Override
    public String create() {

        final StringBuilder newline = new StringBuilder().append(LINE_SEPARATOR);

        for (int i = 0, indentFactor = indent.getIndentFactor(); i < indentFactor; i++) {
            newline.append(indent.getIndent());
        }

        return newline.toString();
    }
}
