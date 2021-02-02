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

import org.thinkit.api.catalog.BiCatalog;
import org.thinkit.formatter.common.catalog.Whitespace;

import lombok.NonNull;

/**
 * トークナイザーを抽象化したインターフェースです。
 *
 * @author Kato Shinya
 * @since 1.0.0
 */
public interface Tokenizable {

    /**
     * 引数として指定された {@code token} に格納された値に空白が含まれているか判定します。
     *
     * @param token 判定対象のトークン
     * @return 引数として指定された {@code token} に格納された値に空白が含まれている場合は {@code true} 、それ以外は
     *         {@code false}
     *
     * @exception NullPointerException 引数として {@code null} が渡された場合
     */
    default boolean isWhitespace(@NonNull String token) {
        return BiCatalog.contains(Whitespace.class, token);
    }

    /**
     * トークナイザから現在のポインタが指すトークンを取得し、トークナイザの位置をインクリメントします。
     * <p>
     * {@link #next()} メソッドを実行した際にトークナイザから取得できるトークンが存在しない場合は {@code false}
     * を返却します。取得できるトークンが存在する場合は {@code true} を返却します。
     * <p>
     * {@link #next()} メソッドの実行後は以下の {@code Getter} メソッドを使用することでトークンを取得することができます。
     * <p>
     * ・現在位置のトークン -> {@link #getToken()}
     * <p>
     * ・現在位置の小文字化されたトークン -> {@link #getLowercaseToken()}
     * <p>
     * ・{@link #next()} メソッド実行前のトークン -> {@link #getLastToken()}
     *
     * @return {@link #next()} メソッドを実行した際にトークナイザから取得できるトークンが存在しない場合は {@code false}
     *         、取得できるトークンが存在する場合は {@code true}
     */
    public boolean next();

    /**
     * 現在位置のトークンを返却します。
     *
     * @return 現在位置のトークン
     */
    public String getToken();

    /**
     * 現在位置の小文字化されたトークンを返却します。
     *
     * @return 現在位置の小文字化されたトークン
     */
    public String getLowercaseToken();

    /**
     * {@link #next()} メソッドが実行される1つ前のトークンを返却します。
     *
     * @return 1つ前のトークン
     */
    public String getLastToken();
}
