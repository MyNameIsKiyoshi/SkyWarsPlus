/*
 * Copyright (c) 2022. YumaHisai
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cf.speederscoders.skywarsplus.backend;

import cf.speederscoders.skywarsplus.api.Format;
import cf.speederscoders.skywarsplus.api.Message;
import cf.speederscoders.skywarsplus.api.Sounds;
import cf.speederscoders.skywarsplus.api.Stack;

import java.util.Random;

/**
 * Chance Created 4/8/2022
 * By YumaHisai at 1:05 PM
 */

public abstract class UTILS {

    public Format format = new Format();

    public Sounds sounds = new Sounds();

    public Stack stack = new Stack();

    public Message messages = new Message();

    double rand = Math.random();

    public double getChance(){
        int rand_ = new Random().nextInt(100) - 1 + 3 * 2;
        return rand + rand_;
    }



}
