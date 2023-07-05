 # Explanation and examples of methods of java stream structure


+ Java stream structure is a feature that is used to perform operations on a group of data sequentially or in parallel with a functional approach. It was added to Java 8 and appeared to improve data processing performance, improve code readability, and work with collections more easily.

+ To use the Stream structure, you need a resource. This resource can be an array, a collection, a file, or a lambda expression.
<div align="center"><h2>Some stream functions and properties.</h2></div>
<div align="center">
<table class="alt">
<tbody><tr>
<th>Methods</th>
<th>Description</th>
</tr>
<tr>
<td>boolean allMatch(Predicate&lt;? super T&gt; predicate)</td>
<td>It returns all elements of this stream which match the provided predicate. If the stream is empty then true is returned and the predicate is not evaluated.</td>
</tr>
<tr>
<td>boolean anyMatch(Predicate&lt;? super T&gt; predicate)</td>
<td>It returns any element of this stream that matches the provided predicate. If the stream is empty then false is returned and the predicate is not evaluated.</td>
</tr>
<tr>
<td>static &lt;T&gt; Stream.Builder&lt;T&gt; builder()</td>
<td>It returns a builder for a Stream.</td>
</tr>
<tr>
<td>&lt;R,A&gt; R collect(Collector&lt;? super T,A,R&gt; collector)</td>
<td>It performs a mutable reduction operation on the elements of this stream using a Collector. A Collector encapsulates the functions used as arguments to collect(Supplier, BiConsumer, BiConsumer), allowing for reuse of collection strategies and composition of collect operations such as multiple-level grouping or partitioning.</td>
</tr>
<tr>
<td>&lt;R&gt; R collect(Supplier&lt;R&gt; supplier, BiConsumer&lt;R,? super T&gt; accumulator, BiConsumer&lt;R,R&gt; combiner)</td>
<td>It performs a mutable reduction operation on the elements of this stream. A mutable reduction is one in which the reduced value is a mutable result container, such as an ArrayList, and elements are incorporated by updating the state of the result rather than by replacing the result.</td>
</tr>
<tr>
<td>static &lt;T&gt; Stream&lt;T&gt; concat(Stream&lt;? extends T&gt; a, Stream&lt;? extends T&gt; b)</td>
<td>It creates a lazily concatenated stream whose elements are all the elements of the first stream followed by all the elements of the second stream. The resulting stream is ordered if both of the input streams are ordered, and parallel if either of the input streams is parallel. When the resulting stream is closed, the close handlers for both input streams are invoked.</td>
</tr>
<tr>
<td>long count()</td>
<td>It returns the count of elements in this stream. This is a special case of a reduction.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; distinct()</td>
<td>It returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.</td>
</tr>
<tr>
<td>static &lt;T&gt; Stream&lt;T&gt; empty()</td>
<td>It returns an empty sequential Stream.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; filter(Predicate&lt;? super T&gt; predicate)</td>
<td>It returns a stream consisting of the elements of this stream that match the given predicate.</td>
</tr>
<tr>
<td>Optional&lt;T&gt; findAny()</td>
<td>It returns an Optional describing some element of the stream, or an empty Optional if the stream is empty. </td>
</tr>
<tr>
<td>Optional&lt;T&gt; findFirst()</td>
<td>It returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty. If the stream has no encounter order, then any element may be returned.</td>
</tr>
<tr>
<td>&lt;R&gt; Stream&lt;R&gt; flatMap(Function&lt;? super T,? extends Stream&lt;? extends R&gt;&gt; mapper)</td>
<td>It returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)</td>
</tr>
<tr>
<td>DoubleStream flatMapToDouble(Function&lt;? super T,? extends DoubleStream&gt; mapper)</td>
<td>It returns a DoubleStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have placed been into this stream. (If a mapped stream is null an empty stream is used, instead.)</td>
</tr>
<tr>
<td>IntStream flatMapToInt(Function&lt;? super T,? extends IntStream&gt; mapper)</td>
<td>It returns an IntStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)</td>
</tr>
<tr>
<td>LongStream flatMapToLong(Function&lt;? super T,? extends LongStream&gt; mapper)</td>
<td>It returns a LongStream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element. Each mapped stream is closed after its contents have been placed into this stream. (If a mapped stream is null an empty stream is used, instead.)</td>
</tr>
<tr>
<td>void forEach(Consumer&lt;? super T&gt; action)</td>
<td>It performs an action for each element of this stream.</td>
</tr>
<tr>
<td>void forEachOrdered(Consumer&lt;? super T&gt; action)</td>
<td>It performs an action for each element of this stream, in the encounter order of the stream if the stream has a defined encounter order. </td>
</tr>
<tr>
<td>static &lt;T&gt; Stream&lt;T&gt; generate(Supplier&lt;T&gt; s)</td>
<td>It returns an infinite sequential unordered stream where each element is generated by the provided Supplier. This is suitable for generating constant streams, streams of random elements, etc.</td>
</tr>
<tr>
<td>static &lt;T&gt; Stream&lt;T&gt; iterate(T seed,UnaryOperator&lt;T&gt; f)</td>
<td>It returns an infinite sequential ordered Stream produced by iterative application of a function f to an initial element seed, producing a Stream consisting of seed, f(seed), f(f(seed)), etc.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; limit(long maxSize)</td>
<td>It returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.</td>
</tr>
<tr>
<td>&lt;R&gt; Stream&lt;R&gt; map(Function&lt;? super T,? extends R&gt; mapper)</td>
<td>It returns a stream consisting of the results of applying the given function to the elements of this stream.</td>
</tr>
<tr>
<td>DoubleStream mapToDouble(ToDoubleFunction&lt;? super T&gt; mapper)</td>
<td>It returns a DoubleStream consisting of the results of applying the given function to the elements of this stream.</td>
</tr>
<tr>
<td>IntStream mapToInt(ToIntFunction&lt;? super T&gt; mapper)</td>
<td>It returns an IntStream consisting of the results of applying the given function to the elements of this stream.</td>
</tr>
<tr><td>LongStream mapToLong(ToLongFunction&lt;? super T&gt; mapper)</td>
<td>It returns a LongStream consisting of the results of applying the given function to the elements of this stream.</td>
</tr>
<tr>
<td>Optional&lt;T&gt; max(Comparator&lt;? super T&gt; comparator)</td>
<td>It returns the maximum element of this stream according to the provided Comparator. This is a special case of a reduction. </td>
</tr>
<tr>
<td>Optional&lt;T&gt; min(Comparator&lt;? super T&gt; comparator)</td>
<td>It returns the minimum element of this stream according to the provided Comparator. This is a special case of a reduction. </td>
</tr>
<tr>
<td>boolean noneMatch(Predicate&lt;? super T&gt; predicate)</td>
<td>It returns elements of this stream match the provided predicate. If the stream is empty then true is returned and the predicate is not evaluated.</td>
</tr>
<tr>
<td>@SafeVarargs static &lt;T&gt; Stream&lt;T&gt; of(T... values)</td>
<td>It returns a sequential ordered stream whose elements are the specified values.</td>
</tr>
<tr>
<td>static &lt;T&gt; Stream&lt;T&gt; of(T t)</td>
<td>It returns a sequential Stream containing a single element.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; peek(Consumer&lt;? super T&gt; action)</td>
<td>It returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream.</td>
</tr>
<tr>
<td>Optional&lt;T&gt; reduce(BinaryOperator&lt;T&gt; accumulator)</td>
<td>It performs a reduction on the elements of this stream, using an associative accumulation function, and returns an Optional describing the reduced value, if any.</td>
</tr>
<tr>
<td>T reduce(T identity, BinaryOperator&lt;T&gt; accumulator)</td>
<td>It performs a reduction on the elements of this stream, using the provided identity value and an associative accumulation function, and returns the reduced value.</td>
</tr>
<tr>
<td>&lt;U&gt; U reduce(U identity, BiFunction&lt;U,? super T,U&gt; accumulator, BinaryOperator&lt;U&gt; combiner)</td>
<td>It performs a reduction on the elements of this stream, using the provided identity, accumulation and combining functions.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; skip(long n)</td>
<td>It returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. If this stream contains fewer than n elements then an empty stream will be returned.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; sorted()</td>
<td>It returns a stream consisting of the elements of this stream, sorted according to natural order. If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed.</td>
</tr>
<tr>
<td>Stream&lt;T&gt; sorted(Comparator&lt;? super T&gt; comparator)</td>
<td>It returns a stream consisting of the elements of this stream, sorted according to the provided Comparator. </td>
</tr>
<tr>
<td>Object[] toArray()</td>
<td>It returns an array containing the elements of this stream.</td>
</tr>
<tr>
<td>&lt;A&gt; A[] toArray(IntFunction&lt;A[]&gt; generator)</td>
<td>It returns an array containing the elements of this stream, using the provided generator function to allocate the returned array, as well as any additional arrays that might be required for a partitioned execution or for resizing.</td>
</tr>
</tbody></table>
</div>